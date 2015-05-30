package com.example.ioedu.firstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by ioedu on 30/05/15.
 */
public class HelloBroadcastReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d("HelloBroadcastReceiver","HelloBroadcast.onReceive:On PowerConnected");
    }
}
