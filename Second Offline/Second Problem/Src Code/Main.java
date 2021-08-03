package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    while (true){
            System.out.print("Enter File name ,or q to quit : ");
            String in = scanner.nextLine();
            if(in.equalsIgnoreCase("q")) break;
            Editor editor =Editor.getEditor();
            editor.set(in);
            editor.show();
        }
    }
}
