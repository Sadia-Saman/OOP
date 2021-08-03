package com.company;

public class CParser implements Parser{
    private  String name;

    public CParser(String name) {
        this.name = name;
    }

    @Override
    public void parse() {
        System.out.println("Parsing with C");
    }

    @Override
    public String toString() {
        return name;
    }
}
