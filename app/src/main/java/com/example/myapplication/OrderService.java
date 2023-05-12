package com.example.myapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    interface  bludoActionListener{

        void  addOrder(Bludo bludo,int count);
        void removeOrder(Bludo bludo,int count);
    }
   public static  List<Order> orders =new ArrayList<Order>();



    public void addOrder(Bludo bludo,int count){

        if (count ==1){
            orders.add(new Order(bludo.bludoName,count));
        }
         else {
             orders.get(getIndex(bludo.bludoName)).setCount(count);
        }
    }

    public void removeOrder(Bludo bludo,int count){


        if (count==0){
            orders.remove(getIndex(bludo.bludoName));
        }
        else {
            orders.get(getIndex(bludo.bludoName)).setCount(count);
        }
    }

    public   int getIndex(String bludoName) {
        int index=-1;
        for (int i = 0; i < orders.size(); i++) {
            Log.i("happy", orders.get(i).bludoName);
            if (orders.get(i).bludoName.equals(bludoName)) {
                index=i;

            }
        }
        return index;

    }

}
