package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder>{

    private LayoutInflater inflater;
    private List<Order> orders;

    public OrderAdapter(Context context, List<Order> orders) {
        this.inflater = LayoutInflater.from(context);
        this.orders = orders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.order_item, parent, false);
        return new OrderAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bludoName.setText(orders.get(position).bludoName);
        holder.tvCount.setText(String.valueOf(orders.get(position).count));
        holder.bludoView.setImageResource(R.drawable.harcho);

    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView bludoView;
        TextView bludoName, tvCount;

        ViewHolder(View view) {
            super(view);
            cv = view.findViewById(R.id.card_view2);
            bludoView = view.findViewById(R.id.bludo_photo);
            bludoName = view.findViewById(R.id.bludo_name);
            tvCount = view.findViewById(R.id.bludo_count);


        }
    }
}
