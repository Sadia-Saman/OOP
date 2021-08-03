package com.company;

import java.util.LinkedList;

public class Device {

    private LinkedList<String> components;
    public Device(){
        components = new LinkedList<String>();
    }
    public void addComponents(String s){
        components.addLast(s);
    }

    @Override
    public String toString() {
        return "{\n" +
                "components =" + components +
                '}';
    }
}
