package com.client.chat.bluetoothchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.client.chat.R;

public class MainActivity extends SampleActivityBase {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
