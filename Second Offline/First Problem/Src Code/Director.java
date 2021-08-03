package com.company;

import java.util.Scanner;

public class Director {
    DeviceBuilder builder ;
    private String internet;
    private String frame;
    private String weightMeasuretype;
    private Scanner scanner;
    private String []internetModes;

    public Director(){
        scanner = new Scanner(System.in);
        internetModes = new String[3];
        internetModes[0]="WiFi Module";
        internetModes[1]="GSM Module";
        internetModes[2] ="";
    }

    public void choosePackage(){
        System.out.println("Available Packages :");
        System.out.println("1: Silver -> ATMega32 with load sensor");
        System.out.println("2: Gold -> Arduino with weight module");
        System.out.println("3: Diamond -> Raspberry Pi with load sensor");
        System.out.println("4: Platinum -> Raspberry Pi with weight module");
        System.out.print("Enter Package number => ");
        int choice;
        choice = scanner.nextInt();
        if(choice==1){
            builder = new DeviceBuilder("ATMega32");
            weightMeasuretype = "load sensor";
            internet =chooseNetConnection(internetModes);
        }else if(choice==2){
            builder = new DeviceBuilder("Arduino");
            weightMeasuretype = "weight module";
            internet =chooseNetConnection(internetModes);
        }else if(choice==3){
            builder = new DeviceBuilder("Raspberry Pi");
            weightMeasuretype = "load sensor";
            internetModes[2] = "Ethernet";
            internet =chooseNetConnection(internetModes);
        }else if(choice==4){
            builder = new DeviceBuilder("Raspberry Pi");
            weightMeasuretype = "weight module";
            internetModes[2] = "Ethernet";
            internet =chooseNetConnection(internetModes);
        }else{
            choosePackage();
        }
        internetModes[2] = "";
        frame = chooseWebFrame();
    }
    private String chooseNetConnection(String []internets){
        System.out.println("Available Internet Mode :");
        int j=0;
        for(int i=0;i<internets.length;i++){
            if(!internets[i].equals("")){
                System.out.println((i+1)+": "+internets[i]);
                j++;
            }

        }

        System.out.print("Enter Internet Mode number => ");
        int choice;
        choice = scanner.nextInt();
        if(choice<=j) return internets[choice-1];
        else return chooseNetConnection(internets);
    }
    private String chooseWebFrame(){
        System.out.println("Allowed WebFrames :");
        System.out.println("1: Django");
        System.out.println("2: Spring");
        System.out.println("3: Laravel");
        System.out.print("Enter frame number => ");
        int choice;
        choice = scanner.nextInt();
        if(choice==1) return "Django";
        else if(choice==2) return "Spring";
        else if(choice==3) return "Laravel";
        else return chooseWebFrame();
    }

    public Device makeDevice(){
        System.out.println("Device is being built :");
        builder.measureWeight(weightMeasuretype);
        builder.storage();
        builder.identify();
        builder.connectInternet(internet);
        builder.display();
        builder.addController();
        System.out.println("Webframe : "+frame);
        System.out.println("Internet : "+internet);
        return builder.getDevice();
    }
}
