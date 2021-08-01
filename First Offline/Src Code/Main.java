package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	    Bank bank = new Bank();
        String input;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bank Created; M D, S 1 , S 2 , C 1 , C 2 , C 3 , C 4 , C 5 created ");

        while(true){
            input = scanner.nextLine();
            if(input.equalsIgnoreCase("x")) break;
            String[] in = input.split(" ");
            if(in[0].equalsIgnoreCase("inc")){
                bank.increamentYear();
                continue;
            }
            String current_person = in[1];
            boolean isEmp = false;
            if(in[0].equalsIgnoreCase("create")){
                int amount = Integer.parseInt(in[3].replaceAll(",", ""));
                bank.makeAccount(in[1],in[2],amount);
            }
            else{
                ArrayList<Employee> employees = bank.getEmployee();
                for(Employee employee: employees){
                    if(employee.getName().equals(in[1])) {
                        isEmp = true;
                        break;
                    }
                }


                if(isEmp) {
                    System.out.print(in[1]+" active");
                    if(bank.getNumberOfLoans()>0) System.out.print(", there are loan approvals pending");
                    System.out.println();
                }
                else {
                    ArrayList<Account> accounts = bank.getAccounts();
                    boolean isAcc=false;
                    System.out.println(in[1]);
                    for(Account account : accounts){
                        if(account.getName().equalsIgnoreCase(in[1])){
                            System.out.println("Welcome back,"+in[1]);
                            isAcc = true;
                        }
                    }
                    if(!isAcc){
                        System.out.println("No account found.");
                        continue;
                    }

                }
            }
            while(true){
                input = scanner.nextLine();
                if(input.toLowerCase().contains("close")) break;
                else if(input.equalsIgnoreCase("inc")){
                    bank.increamentYear();
                    continue;
                }

                in = input.split(" ");
                if(isEmp){
                    if(in.length==1) bank.operate(current_person);
                    else if(in.length==2) bank.operate(current_person,in[0],in[1]);
                    else  if(in.length==3)bank.operate(current_person,in[1],Double.parseDouble(in[2].replaceAll(",", "")));
                }else{
                    if(in.length==1) bank.transact(current_person);
                    else if(in.length==2) bank.transact(current_person,in[0],Integer.parseInt(in[1].replaceAll(",", "")));
                }

            }
            if(isEmp) System.out.println("Operations for "+ current_person+" closed");
            else System.out.println("Transaction Closed for "+current_person);
        }
    }


}


