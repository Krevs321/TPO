package com.example.tpoapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SeznanjeneNaprave extends AppCompatActivity
{
    ImageButton back;

    RecyclerView recyclerView;

    DBHelper myDB;
    ArrayList<String> device_id, device_name, device_info;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seznanjenenaprave);

        recyclerView = findViewById(R.id.recyclerView);

        myDB = new DBHelper(SeznanjeneNaprave.this);
        device_id = new ArrayList<>();
        device_name = new ArrayList<>();
        device_info = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(SeznanjeneNaprave.this, device_id, device_name, device_info);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(SeznanjeneNaprave.this));

    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No Data!", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                device_id.add(cursor.getString(0));
                device_name.add(cursor.getString(1));
                device_info.add(cursor.getString(2));
            }
        }
    }
}
