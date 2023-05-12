package com.example.myapplication;

public class Order {
   Bludo bludo;
    int count;

    public Order(Bludo bludo, int count) {
        this.bludo = bludo;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
