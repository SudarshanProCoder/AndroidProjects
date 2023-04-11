package com.example.databaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, roll_no, st_class;
    Button submit;
    Spinner elective_Sub;
    RadioGroup gender;
    MyDBHelper myDBHelper;
    String elesub;
    String[] electiveSub = {"WBP", "NIS"};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.textName);
        roll_no = findViewById(R.id.textRollno);
        st_class = findViewById(R.id.textClass);
        submit = findViewById(R.id.submitBtn);
        gender = findViewById(R.id.radioGender);
        elective_Sub = findViewById(R.id.electiveSubjects);
        myDBHelper = new MyDBHelper(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, electiveSub);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        elective_Sub.setAdapter(adapter);

        elective_Sub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, electiveSub[i], Toast.LENGTH_SHORT).show();
                elesub = electiveSub[i];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        submit.setOnClickListener(view -> {
            String stName =  name.getText().toString();
            String stRollNo =  roll_no.getText().toString();
            String stClass =  st_class.getText().toString();

            int selectedId = gender.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(selectedId);
            String stGender = radioButton.getText().toString();
            StudentModel studentModel =  new StudentModel(stName, stRollNo, stClass, stGender, elesub);
            myDBHelper.insert(studentModel);
            Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
        });

    }
}