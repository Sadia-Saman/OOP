package com.company;

public class ManagingDirector extends Officer{
    public ManagingDirector(String name) {
        super(name);
    }

    public void seeInternalFund(int internal_Fund){
        System.out.println("Internal Fund is "+internal_Fund+"$");

    }
    public double changeInterestRate(String type,double newRate){
        System.out.println("New Interest Rate for "+type+" is "+newRate);
        return newRate;
    }
}
