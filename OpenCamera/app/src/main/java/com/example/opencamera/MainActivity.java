package com.example.opencamera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button openCamera, openVideo;
    ImageView imageView;
    VideoView videoView;
    private final int REQUEST_CODE_CAMERA_PIC = 100;
    private final int REQUEST_CODE_CAMERA_VIDEO = 101;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openCamera = findViewById(R.id.takeImageBtn);
        imageView = findViewById(R.id.imageView);
        openVideo = findViewById(R.id.takeVideoBtn);
        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                camera.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 10);
                startActivityForResult(camera, REQUEST_CODE_CAMERA_PIC);

            }
        });
        openVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(camera, REQUEST_CODE_CAMERA_VIDEO);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){

            if(requestCode == REQUEST_CODE_CAMERA_PIC){
                Bitmap img = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(img);
            }
            if(requestCode == REQUEST_CODE_CAMERA_VIDEO){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                videoView = new VideoView(this);
                videoView.setVideoURI(data.getData());
                videoView.start();
                builder.setView(videoView).show();
            }

        }
    }
}