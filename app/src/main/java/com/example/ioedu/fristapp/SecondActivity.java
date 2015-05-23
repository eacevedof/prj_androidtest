package com.example.ioedu.fristapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by ioedu on 23/05/15.
 */
public class SecondActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_main);
        Log.d("SECOND ACTIVITY","onCreate");
        String sFromMain = getIntent().getStringExtra("firstValue");
        Log.d("sFromMain:",sFromMain);

    }
}
