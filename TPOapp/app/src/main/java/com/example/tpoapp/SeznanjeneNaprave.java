package com.example.tpoapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class SeznanjeneNaprave extends AppCompatActivity
{
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

        customAdapter = new CustomAdapter(SeznanjeneNaprave.this, this, device_id, device_name, device_info);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(SeznanjeneNaprave.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1)
        {
            recreate();
        }
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
