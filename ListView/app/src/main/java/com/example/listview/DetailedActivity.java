package com.example.listview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.databinding.ActivityDetailedBinding;

public class DetailedActivity extends AppCompatActivity {

    ActivityDetailedBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();

        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FF000000")));

        Intent intent = this.getIntent();
        if(intent != null){
            String name = intent.getStringExtra("name");
            String founder = intent.getStringExtra("founder");
            int image = intent.getIntExtra("image", R.drawable.img1);

            binding.detailImage.setImageResource(image);
            binding.detaiName.setText(name);
            binding.detailedFounder.setText(founder);

        }


    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(DetailedActivity.this, MainActivity.class);
        startActivity(intent);
    }
}