package com.company;

public class DeviceBuilder implements Builder{
    private String mpName;
    private Device device;

    public DeviceBuilder(String name) {
        this.mpName=name;
        device =  new Device();
        device.addComponents(name);
    }

    @Override
    public void measureWeight(String type) {
        System.out.println("Weight Measurement with : "+type);
        device.addComponents(type);
    }

    @Override
    public void identify() {
        String Identification;
        if(mpName.equalsIgnoreCase("ATMega32" ) || mpName.equalsIgnoreCase("Arduino"))
            Identification = " RFID card";
        else Identification="NFC card";
        System.out.println("Identify with "+ Identification);
        device.addComponents(Identification);
    }

    @Override
    public void storage() {
        String Storage;
        if(mpName.equalsIgnoreCase("ATMega32" ) || mpName.equalsIgnoreCase("Arduino"))
            Storage = " SD card";
        else Storage="BuiltIn";
        System.out.println("Storage : "+ Storage);
        device.addComponents(Storage);
    }

    @Override
    public void display() {
        String Display;
        if(mpName.equalsIgnoreCase("ATMega32" ))
           Display = " LCD display";
        else if(mpName.equalsIgnoreCase("Arduino"))
            Display="LED display";
        else Display="Touch Screen";
        System.out.println("Display : "+ Display);
        device.addComponents(Display);
    }

    @Override
    public void connectInternet(String type) {
        System.out.println("Connecting Internet with "+type);
        device.addComponents(type);
    }

    @Override
    public void addController() {
        String controller;
        if(mpName.equalsIgnoreCase("ATMega32" ) || mpName.equalsIgnoreCase("Arduino"))
            controller  = " Button";
        else controller="Double Screen";
        System.out.println("Controller : "+controller+ " added");
        device.addComponents(controller);
    }


    @Override
    public Device getDevice() {
        return device;
    }
}
