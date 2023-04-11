package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        display = findViewById(R.id.factorial_display);
        Intent intent = getIntent();
       long num =  intent.getLongExtra("result", 0);
        display.setText("Factorial = " + num);
    }
}