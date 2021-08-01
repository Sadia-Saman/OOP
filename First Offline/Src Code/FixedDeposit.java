package com.company;

public class FixedDeposit extends Account{
    public FixedDeposit(String name, int initialDeposit,double rate) {
        super(name,initialDeposit,rate);
    }

    public void requestLoan(int amount){
        if(amount<=100000 ) System.out.println("Loan request successful, sent for approval");
        else System.out.println("Loan request unsuccessful :(");
    }
    public void deposit(int amount){
        if(amount>=50000) super.deposit(amount);
        else System.out.println("Invalid transaction .");
    }
    public void withdraw(int amount){
        if(maturityperiod>=1) super.withdraw(amount);
        else System.out.println("Invalid transaction .");
    }
}
