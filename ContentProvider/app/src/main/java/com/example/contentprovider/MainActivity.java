package com.example.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button add_data, retrive_data;
    EditText name, roll_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_data = findViewById(R.id.add_data);
        retrive_data = findViewById(R.id.retrive_data);
        name = findViewById(R.id.name);
        roll_no = findViewById(R.id.roll_no);

        add_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(StudentData.NAME, name.getText().toString());

                contentValues.put(StudentData.ROLL_NO, roll_no.getText().toString());

                Uri uri = getContentResolver().insert(StudentData.CONTENT_URI, contentValues);
                Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        retrive_data.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                String URL = "content://com.example.contentprovider.StudentData";

                Uri students = Uri.parse(URL);
                Cursor c = managedQuery(students, null, null, null, "name");

                if (c.moveToFirst()) {
                    do {
                        Toast.makeText(MainActivity.this, c.getString(c.getColumnIndex(StudentData._ID)) + ", " + c.getString(c.getColumnIndex(StudentData.NAME)) + ", " + c.getString(c.getColumnIndex(StudentData.ROLL_NO)), Toast.LENGTH_SHORT).show();
                    } while (c.moveToNext());
                }
            }
        });

    }
}