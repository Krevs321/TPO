package com.example.tpoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBHandler dbHandler;
    List<Object> strezniki = new ArrayList<>();
    List<Object> naprave = new ArrayList<>();

    Button dodaj_napravo_scan;
    Button dodaj_streznik_scan;
    Button vse_naprave;
    Button vsi_strezniki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VSI ORIGINALNI GUMBI
        dodaj_napravo_scan = findViewById(R.id.dodaj_napravo);
        dodaj_streznik_scan = findViewById(R.id.dodaj_streznik);
        vse_naprave = findViewById(R.id.seznanjene_naprave);
        vsi_strezniki = findViewById(R.id.seznanjeni_strezniki);

        //SKENIRANJE
        dodaj_napravo_scan.setOnClickListener(v ->
        {
            scanNaprava();
        });
        dodaj_streznik_scan.setOnClickListener(v ->
        {
            scanStreznik();
        });

        //SEZNANNJENE NAPRAVE GUMB
        vse_naprave.setOnClickListener(l ->{
            Intent vse_naprave_intent = new Intent(this, SeznanjeneNaprave.class);
            startActivity(vse_naprave_intent);
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
            naprave.add(result.getContents());
            Toast.makeText(getApplicationContext(), "Skenirana naprava: " + result.getContents(), Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Narobe skenirana naprava", Toast.LENGTH_SHORT).show();
        }
    });

    private void scanStreznik()
    {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to use flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);

        barLauncher2.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLauncher2 = registerForActivityResult(new ScanContract(), result -> {
        if(result.getContents() != null && result.getContents().startsWith("streznik"))
        {
            strezniki.add(result.getContents());
            Toast.makeText(getApplicationContext(),"Skenirana naprava: " + result.getContents(), Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Narobe skenirana naprava", Toast.LENGTH_SHORT).show();
        }
    });
}