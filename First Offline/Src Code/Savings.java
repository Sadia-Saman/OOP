package com.company;

public class Savings extends  Account{
    public Savings(String name, int initialDeposit,double rate) {
        super(name,initialDeposit,rate);
    }

    public void requestLoan(int amount){
        if(amount<=10000 ) System.out.println("Loan request successful, sent for approval");
        else System.out.println("Loan request unsuccessful :(");
    }

    public void withdraw(int amount){
        if((super.getDeposit()-amount)>=1000) super.withdraw(amount);
        else System.out.println("Invalid transaction .");
    }
}
