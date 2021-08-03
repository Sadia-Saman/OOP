package com.company;

public class CAesthetics implements Aesthetics{
    @Override
    public void font() {
        System.out.println("Font for C is Courier New");
    }

    @Override
    public void color() {
        System.out.println("Default color is Blue");
    }

    @Override
    public void style() {
        System.out.println("Default Style is Normal");
    }
}
