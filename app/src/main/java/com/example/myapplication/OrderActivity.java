package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class OrderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView tvSumma;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        recyclerView= findViewById(R.id.rvOrder);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        OrderAdapter orderAdapter=new OrderAdapter(this,OrderService.orders );
        recyclerView.setAdapter(orderAdapter);

        tvSumma = findViewById(R.id.summa);
        tvSumma.setText("ИТОГО: "+String.valueOf(checkSumm(OrderService.orders))+" руб.");


    }

    private float checkSumm(List<Order> orders){
        float summ=0;
        for(Order order: orders){
            summ+=order.bludo.cost*order.count;
        }
        return summ;
    }
}