package com.company;

import java.util.ArrayList;

public class Bank {
        private int internal_Fund ;
        private ArrayList< Employee> employees ;

        private ArrayList<Account> accounts;
        private  ArrayList<String> loanRequests;
        private ArrayList<Integer> loanAmounts;
        private int numberOfAccounts ;
        private int numberOfLoans ;
        private double interestRateForStudents ;
        private double interestRateForSavings ;
        private double interestRateForFixedDep;
        private int year;

        public Bank() {
            internal_Fund = 1000000;
            accounts = new ArrayList<>();
            loanRequests = new ArrayList<>();
            loanAmounts = new ArrayList<>();
            numberOfAccounts=0;
            numberOfLoans =0;
            interestRateForStudents = 5;
            interestRateForSavings = 10;
            interestRateForFixedDep = 15;
            year=0;
            employees  = new ArrayList<>();
            employees.add(new ManagingDirector("DB"));
            employees.add(new Officer("O1"));
            employees.add( new Officer("O2"));
            for(int i=4 ; i<=8;i++)
                employees.add( new Cashier("C" + i));
        }

    public ArrayList<Account> getAccounts() {
            return  accounts;
    }

    public void resetNUmberOfLoans(){
            numberOfLoans=0;
            loanAmounts.clear();
            loanRequests.clear();
        }

        public int getNumberOfLoans() {
            return numberOfLoans;
        }

        public void makeAccount(String name, String type, int initAmount){
            for (Account account:accounts){
                if(account.getName().equalsIgnoreCase(name)) {
                    System.out.println("Account already exists.");
                    return;
                }
            }
            if(type.toLowerCase().equals("student")) {
                Account student = new  Student(name, initAmount,interestRateForStudents);
                accounts.add( student);
            }else if(type.toLowerCase().contains("saving")){
                Account saving = new Savings(name,initAmount,interestRateForSavings);
                accounts.add(saving);
            }else if(type.toLowerCase().contains("fixed deposit") && initAmount>=100000){
                Account fixedDeposit = new FixedDeposit(name, initAmount,interestRateForFixedDep);
                accounts.add( fixedDeposit);
            }else{
                System.out.println("Account can not be created");
                return;
            }
            numberOfAccounts++;
            System.out.println(type+" account for "+name+" Created; initial balance "+initAmount+"$");
        }
        public void increamentYear(){
            year++;
            System.out.println(year+" year passed");
            for (int i=0;i<numberOfAccounts;i++) {
                accounts.get(i).incMaturityperiod();
                accounts.get(i).deductInterest();
            }
        }

        public void operate(String emp){
            for(int i = 0;i<8;i++){
                if(employees.get(i).getName().equals(emp)){
                    employees.get(i).seeInternalFund(internal_Fund);
                }
            }
        }
        public void operate(String emp,String S,String S2){
            for(int i = 0;i<8;i++){
                if(employees.get(i).getName().equals(emp)){
                    if(S.toLowerCase().contains("approve")){
                        employees.get(i).approveLoan(numberOfLoans,numberOfAccounts,loanRequests,loanAmounts,accounts);
                        resetNUmberOfLoans();
                    }
                    else employees.get(i).lookUp(S2,numberOfAccounts,accounts);
                    break;
                }
            }
        }
        public void operate(String emp,String S,double rate){
            for(int i = 0;i<8;i++){
                if(employees.get(i).getName().equals(emp)){
                    double newRate = employees.get(i).changeInterestRate(S,rate);
                    if(newRate!=-1){
                        double oldRate ;
                        if(S.toLowerCase().equals("student")) {
                            oldRate = interestRateForStudents;
                            interestRateForStudents =newRate;
                        }
                        else if(S.toLowerCase().equals("savings")) {
                            oldRate = interestRateForSavings;
                            interestRateForSavings = newRate;
                        }
                        else {
                            oldRate = interestRateForFixedDep;
                            interestRateForFixedDep = newRate;
                        }
                        for(int j=0;j<numberOfAccounts;j++) {
                            if(accounts.get(j).getInterestRate()==oldRate) accounts.get(j).setInterestRate(newRate);
                        }
                    }
                }
            }
        }
        public void transact(String emp){
            for(int i = 0;i<numberOfAccounts;i++){
                if(accounts.get(i).getName().equals(emp)){
                    accounts.get(i).queryDeposit();
                }
            }
        }
        public void transact(String emp,String S,int amount){
            for(int i = 0;i<numberOfAccounts;i++){
                if(accounts.get(i).getName().equals(emp)){
                    if(S.toLowerCase().contains("deposit"))  accounts.get(i).deposit(amount);
                    else if(S.toLowerCase().contains("withdraw"))  accounts.get(i).withdraw(amount);
                    else if(S.toLowerCase().contains("request")) {
                        if(amount>internal_Fund) {
                            System.out.println("Not available for loan");
                            return;
                        }
                        loanRequests.set(numberOfLoans, accounts.get(i).getName());
                        loanAmounts.set(numberOfLoans++, amount);
                        internal_Fund-=amount;
                        accounts.get(i).requestLoan(amount);
                    }
                    return;
                }
            }

        }

    public ArrayList<Employee> getEmployee() {
            return employees;
    }
}

