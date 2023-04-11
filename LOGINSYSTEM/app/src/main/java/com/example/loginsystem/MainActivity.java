package com.example.loginsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button login;
    TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.textName);
        password = findViewById(R.id.textRollno);
        login = findViewById(R.id.submitBtn);
        error = findViewById(R.id.textError);

        login.setOnClickListener(View ->{
            String name = username.getText().toString();
            String pass = password.getText().toString();

            if(name.equals("sudarshan")){
                if (pass.equals("date2004")){
                    Toast.makeText(this, "Login Successful..", Toast.LENGTH_SHORT).show();
                    error.setText("Welcome Dear " + name);
                    error.setTextColor(Color.GREEN);
                }else{
                    Toast.makeText(this, "Login Unsuccessful..", Toast.LENGTH_SHORT).show();
                    error.setText("Invalid Password");
                    error.setTextColor(Color.RED);


                }
            }else{
                error.setText("Invalid Username");
                error.setTextColor(Color.RED);


            }

        });


    }
}