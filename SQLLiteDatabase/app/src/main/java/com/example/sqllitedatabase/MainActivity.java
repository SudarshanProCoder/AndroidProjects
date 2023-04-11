package com.example.sqllitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText name, branch, roll_no;
    Button insert, update, read, delete;
    DBHelper DB;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        branch = findViewById(R.id.branch);
        roll_no = findViewById(R.id.roll_no);

        insert = findViewById(R.id.btn_insert);
        update = findViewById(R.id.btn_update);
        read = findViewById(R.id.btn_read);
        delete = findViewById(R.id.btn_delete);

        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                String branchText = branch.getText().toString();
                String roll_noText = roll_no.getText().toString();


                Boolean checkinsertdata = DB.insertData(nameText, branchText, roll_noText);
                if (checkinsertdata == true) {
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }


            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                String branchText = branch.getText().toString();
                String roll_noText = roll_no.getText().toString();

                Boolean checkupdatedate = DB.updateData(nameText, branchText, roll_noText);
                if (checkupdatedate == true) {
                    Toast.makeText(MainActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Entry Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();

                Boolean checkdeletedata = DB.deleteData(nameText);
                if (checkdeletedata == true) {
                    Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = DB.getData();
                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();

                while (res.moveToNext()) {
                    buffer.append("Name: " + res.getString(0) + "\n");
                    buffer.append("Branch: " + res.getString(1) + "\n");
                    buffer.append("Roll NO: " + res.getString(2) + "\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Data");
                builder.setMessage(buffer.toString());
                builder.show();
            }


        });
    }
}