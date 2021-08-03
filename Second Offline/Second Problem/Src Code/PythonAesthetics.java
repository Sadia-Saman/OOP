package com.company;

public class PythonAesthetics implements Aesthetics{
    @Override
    public void font() {
        System.out.println("Font for Python is Consolas");
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
