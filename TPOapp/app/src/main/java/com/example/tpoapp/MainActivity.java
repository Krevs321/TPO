package com.example.tpoapp;

import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    private DBHandler dbHandler;
    Button dodaj_napravo_scan;
    Button dodaj_streznik_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DBHandler(MainActivity.this);

        dodaj_napravo_scan = findViewById(R.id.dodaj_napravo);
        dodaj_napravo_scan.setOnClickListener(v ->
        {
            scanCode();
        });
        dodaj_streznik_scan = findViewById(R.id.dodaj_streznik);
        dodaj_streznik_scan.setOnClickListener(v ->
        {
            scanCode();
        });
    }

    private void scanCode()
    {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to use flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);

        barLauncher.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result -> {

        if(result.getContents() != null){
            //Intent next= new Intent(getApplicationContext(), MainActivity.class);
            //startActivity(next);
            dodaj_napravo_scan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = result.getContents();

                    if (name.isEmpty() && !result.getContents().startsWith("test")) {
                        Toast.makeText(MainActivity.this, "Ni zaznanane naprave", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    dbHandler.addNewCourse(name);

                    // after adding the data we are displaying a toast message.
                    Toast.makeText(MainActivity.this, "Naprava je dodana", Toast.LENGTH_SHORT).show();
                    dodaj_napravo_scan.setText("");
                }
            });
        }
    });
}