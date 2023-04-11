package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button factorial;
    EditText number;
    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_main);

        factorial = findViewById(R.id.Factorial);
        number = findViewById(R.id.get_text);

        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = String.valueOf(number.getText());

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                int number = Integer.parseInt(num);
                long result = factorial(number);

                intent.putExtra("result", result);
                startActivity(intent);


            }
        });

    }

    public static long factorial(int number){
        if(number == 0){
            return 1;
        }else{

            return number * factorial(number - 1 );
        }


    }


}