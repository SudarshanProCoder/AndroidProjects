package com.example.loginscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class SpScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
                Boolean check =  sharedPreferences.getBoolean("username", false);
                Intent intent;
               if(check){
                   intent =  new Intent(SpScreen.this, MainActivity.class);

               }
                 else{
                  intent =  new Intent(SpScreen.this, LoginScrenn.class);
                }
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    public class ViewPager extends FragmentPagerAdapter {
        public ViewPager(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return new FragmentA();
                case 1:
                    return new FragmentB();
                case 2:
                    return new FragmentC();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
