package com.example.sensordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout mainBackground;
    private SensorManager sensorManager;
    View view;
    Sensor sensor;
    private long lastUpdate;
    private boolean isColor = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = findViewById(R.id.mainBackground);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
         sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    float[] values = event.values;
                    // Movement
                    float x = values[0];
                    float y = values[1];
                    float z = values[2];

                    float accelationSquareRoot = (float) ((x * x + y * y + z * z) / (9.8 * 9.8));

                    if (accelationSquareRoot >= 2) //it will be executed if you shuffle
                    {
                        if (isColor) {
                            view.setBackgroundColor(Color.GREEN);

                        } else {
                            view.setBackgroundColor(Color.RED);
                        }
                        isColor = !isColor;
                    }
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        sensorManager.registerListener(sensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }


}