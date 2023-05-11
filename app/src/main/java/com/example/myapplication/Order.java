package com.example.myapplication;

public class Order {
    String bludoName;
    int count;

    public Order(String bludoName, int count) {
        this.bludoName = bludoName;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
