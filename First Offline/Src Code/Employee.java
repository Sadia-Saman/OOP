package com.company;

import java.util.ArrayList;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name ;
    }

    public void lookUp(String name, int numberOfAccounts , ArrayList<Account> accounts){
        for(Account account:accounts){
            if (account.getName().equals(name)) {
                System.out.println(name + "'s current balance is "+account.getDeposit());
                break;
            }

        }
    }
    public boolean approveLoan(int numberOfLoans, int numberOfAccounts, ArrayList<String> loanRequests, ArrayList<Integer> loanAmounts, ArrayList<Account> accounts){
        System.out.println("You don’t have permission for this operation");
        return false;
    }
    public void seeInternalFund(int internalFund){
        System.out.println("You don’t have permission for this operation");
    }
    public double changeInterestRate(String type,double newRate){
        System.out.println("You don’t have permission for this operation");
        return -1;
    }
}
