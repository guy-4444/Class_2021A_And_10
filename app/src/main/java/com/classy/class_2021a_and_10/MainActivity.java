package com.classy.class_2021a_and_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView main_LBL_info;
    BootReceiver bootReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_LBL_info = findViewById(R.id.main_LBL_info);

        Intent intent = new Intent(this, HelloService.class);
        startService(intent);

        LightReceiver lightReceiver = new LightReceiver(new LightReceiver.CallBack_light() {
            @Override
            public void light(float value) {
                main_LBL_info.setText("Got it!\n" + value);
            }
        });

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LightReceiver.ACTION_LIGHT);
        registerReceiver(lightReceiver, intentFilter);
        bootReceiver = new BootReceiver();

    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(bootReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (bootReceiver != null)
//            unregisterReceiver(bootReceiver);
    }
}

/*
Heart rate
Finger Print sensor
Camera
Mic

Gyroscope
Accelerometer
Magnometer
Barometer
Temperature
Humidity sensor

Light Sensor
Proximity Sensor

GPS
Wifi
Bluetooth
GSM
NRC




Touch Screen



 */