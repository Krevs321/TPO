package com.example.tpoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeznanjeneNaprave extends AppCompatActivity
{
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seznanjenenaprave);

        back = findViewById(R.id.imageButton_b);

        back.setOnClickListener(l ->{
            Intent vse_naprave_intent = new Intent(this, MainActivity.class);
            startActivity(vse_naprave_intent);
        });
    }
}
