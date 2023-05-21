package com.sudarshancoder.checkboxandradiobutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox ch1, ch2,ch3, ch4;
    ImageButton imageButton;
    ProgressBar pb1, pb2;
    int i = 0;
    Handler handler = new Handler();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch1 = findViewById(R.id.cpp);
        ch2 = findViewById(R.id.java);
        ch3 = findViewById(R.id.php);
        ch4 = findViewById(R.id.python);
        pb1 = findViewById(R.id.pb1);
        pb2 = findViewById(R.id.pb2);



        imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(View->{
            if(ch1.isChecked()){
                Toast.makeText(getApplicationContext(), ch1.getText().toString(), Toast.LENGTH_SHORT).show();
            }
            if(ch2.isChecked()){
                Toast.makeText(getApplicationContext(), ch2.getText().toString(), Toast.LENGTH_SHORT).show();
            }
            if(ch3.isChecked()){
                Toast.makeText(getApplicationContext(), ch3.getText().toString(), Toast.LENGTH_SHORT).show();
            }
            if(ch4.isChecked()){
                Toast.makeText(getApplicationContext(), ch4.getText().toString(), Toast.LENGTH_SHORT).show();
            }
            RadioGroup rg = findViewById(R.id.radioGroup);
            int id = rg.getCheckedRadioButtonId();
            RadioButton rb = findViewById(id);
            Toast.makeText(getApplicationContext(), rb.getText().toString(), Toast.LENGTH_SHORT).show();


                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while(i < 100){
                            i+=10;
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    pb1.setProgress(i);
                                    pb2.setProgress(i);
                                }
                            });
                            try {
                                Thread.sleep(1000);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();



        });




    }
}