package com.sudarshancoder.togglebuttononoffbluetooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton onoff;
    BluetoothAdapter bA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onoff = findViewById(R.id.onoff);

        bA = BluetoothAdapter.getDefaultAdapter();

        onoff.setOnClickListener(View -> {
            if (onoff.isChecked()) {
                if (!bA.isEnabled()) {
                    Intent bluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    startActivityForResult(bluetooth, 101);
                }
            }else{
                bA.disable();
            }
        });
    }
}