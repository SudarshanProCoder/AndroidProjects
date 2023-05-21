package com.sudarshancoder.callactivityapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText phoneno;
    Button call;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneno = findViewById(R.id.phoneno);
        call = findViewById(R.id.call);

        call.setOnClickListener(View->{
            String no = phoneno.getText().toString();
            Intent callProcess = new Intent(Intent.ACTION_CALL);
            callProcess.setData(Uri.parse("tel:" + no));
            if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                return;
            }
            startActivity(callProcess);
        });

    }
}