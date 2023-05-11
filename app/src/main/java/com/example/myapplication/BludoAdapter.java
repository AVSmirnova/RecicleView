package com.example.myapplication;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BludoAdapter extends RecyclerView.Adapter<BludoAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Bludo> bludos;
    private Context context;
    private int count=0;

    private OrderService.bludoActionListener bludoActionListener;

    public BludoAdapter(Context context, List<Bludo> bludos, OrderService.bludoActionListener bludoActionListener ) {
        this.inflater = LayoutInflater.from(context);
        this.bludos = bludos;
        this.context=context;
        this.bludoActionListener=bludoActionListener;

    }

    /*метод вызывается, когда кастомный ViewHolder должен быть инициализирован.
    Мы указываем макет для каждого элемента RecyclerView.
    Затем LayoutInflater заполняет макет, и передает его в конструктор ViewHolder.*/


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);

    }
   // определяем какое поле в каком элементе отображать
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.bludoName.setText(bludos.get(position).bludoName);
       holder.bludoCat.setText(bludos.get(position).category);
       holder.bludoView.setImageResource(bludos.get(position).bludoPicture);

       holder.btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               count=Integer.parseInt(holder.tvCount.getText().toString());
               bludoActionListener.addOrder(bludos.get(holder.getAdapterPosition()),++count);
               holder.tvCount.setText(String.valueOf(count));
           }
       });

       holder.btnRemove.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               count=Integer.parseInt(holder.tvCount.getText().toString());
               if(count==0){
                   return;
               }
               bludoActionListener.removeOrder(bludos.get(holder.getAdapterPosition()),--count);
               holder.tvCount.setText(String.valueOf(count));
           }
       });


    }
   // количество элементов, присутствующих в данных
    @Override
    public int getItemCount() {

        return bludos.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }




    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        ImageView bludoView;
        TextView bludoName, bludoCat, tvCount;
        Button btnAdd,btnRemove;

        ViewHolder(View view){
            super(view);
            cv=view.findViewById(R.id.card_view);
            bludoView = view.findViewById(R.id.bludo_photo);
            bludoName = view.findViewById(R.id.bludo_name);
            bludoCat = view.findViewById(R.id.bludo_cat);
            tvCount =view.findViewById(R.id.count);
            btnAdd =view.findViewById(R.id.btnPlus);
            btnRemove = view.findViewById(R.id.btnMinus);


        }
    }


}
