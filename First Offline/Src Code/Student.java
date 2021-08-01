package com.company;

public class Student extends Account{
    public Student(String name, int initialDeposit,double rate) {
        super(name,initialDeposit,rate);
    }
    public void requestLoan(int amount){
        if(amount<=1000 ) super.requestLoan(amount);
        else System.out.println("Loan request unsuccessful :(");
    }
    public void withdraw(int amount){
        if(amount<=10000) super.withdraw(amount);
        else System.out.print("Invalid transaction .");
        super.queryDeposit();
    }
}
