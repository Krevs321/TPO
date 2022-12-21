package com.example.tpoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateNaprava extends AppCompatActivity {

    EditText device_id, device_name, device_info;
    Button update_button;
    String id, name, info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_naprava);

        device_id = findViewById(R.id.id_naprava_update);
        device_name = findViewById(R.id.name_naprava_update);
        device_info = findViewById(R.id.info_naprava_update2);
        update_button = findViewById(R.id.update_button);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        getAndSetIntentData();
    }

    void getAndSetIntentData()
    {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("info"))
        {
            //GETTING INTENT DATA
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            info = getIntent().getStringExtra("info");

            //SETTING INTENT DATA
            device_id.setText(id);
            device_name.setText(name);
            device_info.setText(info);
        }
        else
        {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }
}