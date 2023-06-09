package com.sudarshancoder.fargamentdemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

   Button signin, signup;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFragment(new AFragment(), 0);
        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);
        signin.setOnClickListener(View->{
            openFragment(new AFragment(), 1);
        });
        signup.setOnClickListener(View->{
            openFragment(new BFragment(), 1);
        });


    }

    public void openFragment(Fragment f, int i){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(i == 1){
            ft.add(R.id.container, f);

        }else{
            ft.replace(R.id.container, f);
        }

        ft.commit();
    }


}