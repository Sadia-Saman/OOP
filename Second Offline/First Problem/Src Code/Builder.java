package com.company;

public interface Builder {
    void measureWeight(String type);
    void identify();
    void storage();
    void display();
    void connectInternet(String type);
    void addController();
    Device getDevice();
}
