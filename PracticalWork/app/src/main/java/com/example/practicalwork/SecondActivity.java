package com.example.practicalwork;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstancedState){
        super.onCreate(savedInstancedState);
        setContentView(R.layout.second_activity);


        Intent intent = getIntent();
         TextView textView = findViewById(R.id.textView);
        textView.setText("Welcome " + intent.getStringExtra("username"));
    }
}
