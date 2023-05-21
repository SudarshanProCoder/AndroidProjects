package com.sudarshancoder.openmapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText address;
    Button getMap;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        address = findViewById(R.id.address);
        getMap = findViewById(R.id.openMap);

        getMap.setOnClickListener(View->{

            String Peraddress  = "http://maps.google.com/maps?daddr="+address.getText().toString();
            Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse(Peraddress));
            startActivity(map);

        });



    }
}