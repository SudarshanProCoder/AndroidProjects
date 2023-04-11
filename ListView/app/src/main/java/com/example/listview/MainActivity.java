package com.example.listview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.listview.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ListAdapter listAdapter;
    ListData listData;
    ArrayList<ListData> listDataArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActionBar actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF000000")));
        int[] Images ={
                R.drawable.billgets, R.drawable.steve, R.drawable.mark, R.drawable.img1,  R.drawable.billgets, R.drawable.steve, R.drawable.mark, R.drawable.img1,  R.drawable.billgets, R.drawable.steve, R.drawable.mark, R.drawable.img1
        };

        String[] Names={
                "Bill Gates","Steve Jobs","Mark Zukurberg","Elon Musk", "Bill Gates","Steve Jobs","Mark Zukurberg","Elon Musk", "Bill Gates","Steve Jobs","Mark Zukurberg","Elon Musk"
        };

        String[] Founder ={

                "Microsoft","Apple","Facebook","SpaceX", "Microsoft","Apple","Facebook","SpaceX", "Microsoft","Apple","Facebook","SpaceX"
        };


        for(int i = 0; i < Images.length; i++){
            listData = new ListData(Images[i], Names[i], Founder[i]);
            listDataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(MainActivity.this, listDataArrayList);


        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
                intent.putExtra("image", Images[position]);
                intent.putExtra("name", Names[position]);
                intent.putExtra("founder", Founder[position]);
                startActivity(intent);
                finish();
            }
        });

    }
}