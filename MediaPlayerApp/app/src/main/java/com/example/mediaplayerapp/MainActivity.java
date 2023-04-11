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

    Button play, pause, vedioPlay;
    MediaPlayer mediaPlayer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.playMusic);
        pause = findViewById(R.id.pauseMusic);
        vedioPlay = findViewById(R.id.videoPlay);

        mediaPlayer = MediaPlayer.create(this, R.raw.music);

        play.setOnClickListener(View ->{
            mediaPlayer.start();
        });
        pause.setOnClickListener(View ->{
            mediaPlayer.pause();
        });
        vedioPlay.setOnClickListener(View ->{

            VideoView videoView =(VideoView)findViewById(R.id.videoView1);

            MediaController mediaController= new MediaController(this);
            mediaController.setAnchorView(videoView);

            String path = "android.resource://com.example.mediaplayerapp/" + R.raw.vi;
            Uri uri=Uri.parse(path);


            videoView.setMediaController(mediaController);
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
        });





    }
}
