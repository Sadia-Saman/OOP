package com.company;

public class PythonParser implements Parser{
    private  String name;
    PythonParser(String s){
        name = s;
    }
    @Override
    public void parse() {
        System.out.println("Parsing with Python");
    }

    @Override
    public String toString() {
        return name;
    }
}
