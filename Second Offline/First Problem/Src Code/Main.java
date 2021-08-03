package com.company;

public class Main {

    public static void main(String[] args) {
        Director director = new Director();
        director.choosePackage();
        Device device = director.makeDevice();
        System.out.println(device);
    }
}
