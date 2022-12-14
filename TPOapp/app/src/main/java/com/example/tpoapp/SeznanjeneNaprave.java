package com.example.tpoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SeznanjeneNaprave extends AppCompatActivity
{
    ImageButton back = findViewById(R.id.imageButton_back);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seznanjenenaprave);

        back.setOnClickListener(l ->{
            Intent main_activity_intent = new Intent(this, MainActivity.class);
            startActivity(main_activity_intent);
        });
    }
}
