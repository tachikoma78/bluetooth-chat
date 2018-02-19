package com.client.chat.common.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.client.chat.common.logger.LogWrapper;

/**
 *
 */

public class SampleBaseActivity extends FragmentActivity {
    public static final String TAG = "SampleActivityBase";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializeLogging();
    }

    // Wraps Android's native log framework
    public void initializeLogging(){
      LogWrapper logWrapper = new LogWrapper();

    }
}
