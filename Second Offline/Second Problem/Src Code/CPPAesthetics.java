package com.company;

public class CPPAesthetics implements Aesthetics{
    @Override
    public void font() {
        System.out.println("Font for CPP is Monaco");
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
