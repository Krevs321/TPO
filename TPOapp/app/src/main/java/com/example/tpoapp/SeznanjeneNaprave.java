package com.example.tpoapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.tpoapp.MainActivity.*;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class SeznanjeneNaprave extends AppCompatActivity
{
    RecyclerView recyclerView;

    DBHelper myDB;
    ArrayList<String> device_id, device_name, device_info;
    CustomAdapter customAdapter;
    ImageButton add_device;

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

        add_device = findViewById(R.id.add_device);
        add_device.setOnClickListener(v ->
        {
            scanNaprava();
        });

    }
    private void scanNaprava()
    {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to use flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);

        barLauncher1.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLauncher1 = registerForActivityResult(new ScanContract(), result -> {

        if(result.getContents() != null && result.getContents().startsWith("naprava")) {
            Toast.makeText(getApplicationContext(), "Skenirana naprava v SezNaprave: " + result.getContents(), Toast.LENGTH_SHORT).show();
            DBHelper database = new DBHelper(SeznanjeneNaprave.this);
            database.addDevice(result.getContents(), result.getContents());
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Narobe skenirana naprava", Toast.LENGTH_SHORT).show();
        }
    });

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
