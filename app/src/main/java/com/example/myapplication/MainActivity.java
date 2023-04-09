package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     List<Bludo> bludos = new ArrayList<Bludo>();
     RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= findViewById(R.id.rv);
        //код для улучшения производительности
       // recyclerView.setHasFixedSize(true);

        //я буду использовать LinearLayoutManager. По умолчанию он обеспечивает вид  RecyclerView аналогично ListView.
        // варинаты LinearLayoutManager,  GridLayoutManager,  StaggeredGridLayoutManager

        GridLayoutManager glm = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(glm);
        initializeData();

        BludoAdapter blAdapter = new BludoAdapter(this,bludos);
        recyclerView.setAdapter(blAdapter);

    }
    private void initializeData(){
        bludos.add(new Bludo("Харчо","Суп", R.drawable.harcho));
        bludos.add(new Bludo("Омлет с луком","Завтрак", R.drawable.omlet));
        bludos.add(new Bludo("Салат летний","Закуски", R.drawable.salat));
        bludos.add(new Bludo("Творог","Завтрак", R.drawable.tvorog));
        bludos.add(new Bludo("Харчо","Суп", R.drawable.harcho));
        bludos.add(new Bludo("Омлет с луком","Завтрак", R.drawable.omlet));
        bludos.add(new Bludo("Салат летний","Закуски", R.drawable.salat));
        bludos.add(new Bludo("Творог","Завтрак", R.drawable.tvorog));

    }
}