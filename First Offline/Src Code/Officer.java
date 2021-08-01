package com.company;

import java.util.ArrayList;

public class Officer extends Employee{
    public Officer(String name) {
        super(name);
    }

    public boolean approveLoan(int numberOfLoans, int numberOfAccounts, ArrayList<String> loanRequests, ArrayList<Integer> loanAmounts, ArrayList<Account> accounts){
        if(numberOfLoans>=1){
            System.out.print("Loan for ");
            for(int i=0;i<numberOfLoans;i++) {
                System.out.print(loanRequests.get(i) +",");
                for(int j=0;j<numberOfAccounts;j++)
                    if(accounts.get(j).getName().equals(loanRequests.get(i))){
                        accounts.get(j).setDeposit(accounts.get(j).getDeposit()+ loanAmounts.get(i));
                        break;
                    }
            }
            System.out.println("approved");
            return true;
        }else {
            System.out.println("No loan request to approve");
            return false;
        }
    }
}
