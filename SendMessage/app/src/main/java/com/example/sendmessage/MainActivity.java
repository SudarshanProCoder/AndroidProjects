package com.example.sendmessage;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.telephony.SmsManager;


import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =100 ;
    Button sendBtn;
    EditText txtphoneNo;
    EditText txtMessage;
    String phoneNo;
    String message;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (Button) findViewById(R.id.sendSms);
        txtphoneNo = (EditText) findViewById(R.id.numberText);
        txtMessage = (EditText) findViewById(R.id.messageText);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                sendSMSMessage();

            }
        });
    }

    protected void sendSMSMessage() {
        phoneNo = txtphoneNo.getText().toString();
        message = txtMessage.getText().toString();

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED) {
            SmsManager smsManager = SmsManager.getDefault();

            smsManager.sendTextMessage(phoneNo, null, message, null, null);

            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        }
    }
}