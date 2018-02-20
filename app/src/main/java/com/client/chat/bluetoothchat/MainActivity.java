package com.client.chat.bluetoothchat;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ViewAnimator;

import com.client.chat.R;
import com.client.chat.common.activities.SampleBaseActivity;
import com.client.chat.common.logger.Log;
import com.client.chat.common.logger.LogFragment;
import com.client.chat.common.logger.LogWrapper;
import com.client.chat.common.logger.MessageOnlyLogFilter;


public class MainActivity extends SampleBaseActivity {

    public static final String TAG = "MainActivity";

    // Whether the Log Fragment is currently shown
    private boolean mLogShown;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            BluetoothChatFragment fragment = new BluetoothChatFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        MenuItem logToggle = menu.findItem(R.id.menu_toggle_log);
        logToggle.setVisible(findViewById(R.id.sample_output) instanceof ViewAnimator);
        logToggle.setTitle(mLogShown? R.string.sample_hide_log : R.string.sample_show_log);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_toggle_log:
                mLogShown = !mLogShown;
                ViewAnimator output = (ViewAnimator) findViewById(R.id.sample_output);
                if(mLogShown){
                    output.setDisplayedChild(1);
                }else{
                    output.setDisplayedChild(0);
                }
        }
        return true;
    }

    @Override
    public void initializeLogging(){
        LogWrapper logWrapper = new LogWrapper();

        Log.setLogNode(logWrapper);

        //Keep message text
        MessageOnlyLogFilter msgFilter = new MessageOnlyLogFilter();
        logWrapper.setNext(msgFilter);

        //On screen logging via a fragment with text view
        LogFragment logFragment = (LogFragment) getSupportFragmentManager().findFragmentById(R.id.log_fragment);
        msgFilter.setNext(logFragment.getmLogView());

        Log.i(TAG, "Ready");
    }


}
