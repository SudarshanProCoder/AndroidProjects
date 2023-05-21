package com.sudarshancoder.navigationbarapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomnavbar);

      bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          @SuppressLint("NonConstantResourceId")
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              int id = item.getItemId();
              if( id == R.id.home){
                  openFragment(new HomeFragment(), false);

              } else if (id == R.id.person) {
                  openFragment(new PersonFragment(), false);

              }else if (id == R.id.comment) {
                  openFragment(new CommentFragment(), false);

              }else if (id == R.id.setting) {
                  openFragment(new SettingFragment(), false);

              }else{
                  openFragment(new ControlFragment(), false);

              }

              return true;

          }
      });

      bottomNavigationView.setSelectedItemId(R.id.home);

    }

    public void openFragment(Fragment f, Boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();


        if(flag){
            ft.add(R.id.container, f);

        }else{
            ft.replace(R.id.container, f);
        }
        ft.commit();
    }
}