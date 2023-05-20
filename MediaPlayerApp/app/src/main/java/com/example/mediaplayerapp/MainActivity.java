package com.example.mediaplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button play, pause;
    MediaPlayer mediaPlayer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.playMusic);
        pause = findViewById(R.id.pauseMusic);

        mediaPlayer = MediaPlayer.create(this, R.raw.s);

        play.setOnClickListener(View ->{
            mediaPlayer.start();
        });
        pause.setOnClickListener(View ->{
            mediaPlayer.pause();
        });






    }
}
