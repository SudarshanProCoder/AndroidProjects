package com.sudarshancoder.fargamentdemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button signin, signup;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fargmentcreate(new AFragment(), 0);

        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);

        signin.setOnClickListener(View -> {
           fargmentcreate(new AFragment(), 1);

        });

        signup.setOnClickListener(View -> {
            fargmentcreate(new BFragment(), 1);

        });
    }

    public void fargmentcreate(Fragment fragment, int flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag == 1){

            ft.add(R.id.container , fragment);
        }else{

            ft.replace(R.id.container, fragment);
        }
        ft.commit();
    }
}