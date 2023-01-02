package com.example.tpoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterServers extends RecyclerView.Adapter<CustomAdapterServers.MyViewHolderServers>
{
    private Context context;
    private ArrayList server_id, username, path;

    CustomAdapterServers(Context context, ArrayList server_id, ArrayList username,  ArrayList path)
    {
        this.context = context;
        this.server_id = server_id;
        this.username = username;
        this.path = path;
    }

    @NonNull
    @Override
    public MyViewHolderServers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_servers, parent, false);

        return new MyViewHolderServers(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderServers holder, int position) {
        holder.server_id.setText(String.valueOf(server_id.get(position)));
        holder.username.setText(String.valueOf(username.get(position)));
        holder.path.setText(String.valueOf(path.get(position)));
    }

    @Override
    public int getItemCount() {
        return server_id.size();
    }

    public class MyViewHolderServers extends RecyclerView.ViewHolder{

        TextView server_id, username, path;

        public MyViewHolderServers(@NonNull View itemView) {
            super(itemView);
            server_id = itemView.findViewById(R.id.server_id);
            username = itemView.findViewById(R.id.username);
            path = itemView.findViewById(R.id.path);

        }
    }
}
