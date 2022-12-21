package com.example.tpoapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList device_id, device_name, device_info;

    CustomAdapter(Context context, ArrayList device_id, ArrayList device_name, ArrayList device_info) {
        this.context = context;
        this.device_id = device_id;
        this.device_name = device_name;
        this.device_info = device_info;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.device_id.setText(String.valueOf(device_id.get(position)));
        holder.device_name.setText(String.valueOf(device_name.get(position)));
        holder.device_info.setText(String.valueOf(device_info.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateNaprava.class);
                /*intent.putExtra("id", String.valueOf(device_id.get(position)));
                intent.putExtra("name", String.valueOf(device_name.get(position)));
                intent.putExtra("info", String.valueOf(device_info.get(position)));*/
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return device_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView device_id, device_name, device_info;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            device_id = itemView.findViewById(R.id.device_id);
            device_name = itemView.findViewById(R.id.device_name);
            device_info = itemView.findViewById(R.id.device_info);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
