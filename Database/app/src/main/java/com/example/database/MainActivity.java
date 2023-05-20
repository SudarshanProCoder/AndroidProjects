package com.example.database;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, address, pincode, mobileNo;
    Button insert, update, delete, read;
    DBHelper database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TEXT FIELDS

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        pincode = findViewById(R.id.pincode);
        mobileNo = findViewById(R.id.mobileno);


        //BUTTONS
        insert = findViewById(R.id.insert);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        read = findViewById(R.id.read);


        //DATABASE

        database = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Address = address.getText().toString();
                String Pincode = pincode.getText().toString();
                String MobileNo = mobileNo.getText().toString();

                if(Name.equals("")||Address.equals("")||Pincode.equals("")||MobileNo.equals("")){
                    Toast.makeText(MainActivity.this, "Please Enter the details ", Toast.LENGTH_SHORT).show();
                }

                Boolean i = database.insertData(Name, Address, Pincode, MobileNo);

                if(i == true){
                    Toast.makeText(MainActivity.this, "Data inserted ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }


            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Address = address.getText().toString();
                String Pincode = pincode.getText().toString();
                String MobileNo = mobileNo.getText().toString();

                Boolean i = database.update_data(Name, Address, Pincode, MobileNo);

                if(i == true){
                    Toast.makeText(MainActivity.this, "Data updated ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }


            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = database.get_data();
                if(cursor.getCount() == 0){
                    Toast.makeText(MainActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                }
                StringBuffer stringBuffer = new StringBuffer();

                while(cursor.moveToNext()){
                    stringBuffer.append("name: " + cursor.getString(1) + "\n");
                    stringBuffer.append("address: " + cursor.getString(2) + "\n");
                    stringBuffer.append("mobile no: " + cursor.getString(3) + "\n");
                    stringBuffer.append("pincode: " + cursor.getString(4) + "\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setCancelable(true);
                builder.setTitle("Customer Data");
                builder.setMessage(stringBuffer.toString());


                builder.show();

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                Boolean t = database.delete_data(Name);

                if(t == true){
                    Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}