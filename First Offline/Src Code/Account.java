package com.company;

public class Account {
    private String name;
    private int Deposit;
    private int loan;
    protected int maturityperiod;
    private double interestRate;

    public  Account(String name,int deposit,double interestRate){
        this.name = name;
        this.Deposit = deposit;
        this.maturityperiod = 0;
        this.interestRate = interestRate;
    }

    public int getDeposit() {
        return Deposit;
    }
    public void incMaturityperiod() {
        maturityperiod ++;
    }

    public void setDeposit(int deposit) {
        Deposit = deposit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void queryDeposit(){
        System.out.print("Current Balance "+Deposit+"$");
        if(loan>0 ) System.out.println("Loan "+loan+"$");
        else System.out.println();
    }

    public String getName() {
        return name;
    }

    public void deposit(int amount){
        Deposit +=amount;
        System.out.print(amount+"$ Deposited; ");
        queryDeposit();
    }
    public void withdraw(int amount){
        if(amount<=Deposit) {
            Deposit-=amount;
            System.out.println("Withdrawal successful");
        }
        else System.out.println("Not Enough Balance");
    }
    public void deductInterest(){
        Deposit = (int) ((double)Deposit + (interestRate*Deposit*0.01));
        Deposit = (int) ((double)Deposit - (loan*0.1));
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void requestLoan(int amount){
        System.out.println("Loan request successful, sent for approval");
    }

}
