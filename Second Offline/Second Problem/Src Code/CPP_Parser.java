package com.company;

public class CPP_Parser implements Parser{
    private  String name;

    public CPP_Parser(String name) {
        this.name = name;
    }

    @Override
    public void parse() {
        System.out.println("Parsing with CPP");
    }

    @Override
    public String toString() {
        return name;
    }
}
