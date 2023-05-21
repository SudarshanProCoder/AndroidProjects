package com.sudarshancoder.newactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        send = findViewById(R.id.send);

        send.setOnClickListener(View->{

            Intent i = new Intent(MainActivity.this, MainActivity2.class);
            i.putExtra("name", name.getText().toString());
            startActivity(i);

        });
    }
}