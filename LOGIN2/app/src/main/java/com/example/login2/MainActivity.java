package com.example.login2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button login;
    TextView error;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.textName);
        password = findViewById(R.id.textRollno);
        login = findViewById(R.id.submitBtn);
        error = findViewById(R.id.textError);

        login.setEnabled(false);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                validateInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        login.setOnClickListener(View ->{
            count++;

            String name = username.getText().toString();
            String pass = password.getText().toString();

            if(name.equals("sudarshan") && !name.equals("")){
                if (pass.equals("date2004") && !pass.equals("")){
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
            if(count == 3){
                login.setVisibility(View.INVISIBLE);
            }

        });





    }
    private void validateInputs() {
        if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            login.setEnabled(false);
        } else {
            login.setEnabled(true);
        }
    }
}