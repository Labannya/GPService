package com.example.newpc.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.NotificationCompat;

/**
 * Created by NewPC on 21/04/2018.
 */

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public  void onReceive(Context context, Intent intent) {


        String time=intent.getStringExtra("snoozeTime");
        String medicine=intent.getStringExtra("medicine");
        NotificationHelper helper= new NotificationHelper(context);
        System.out.println("N started");
        NotificationCompat.Builder nb=helper.getChannel1Notification(time+" minute(s) left taking the medicine","Medicine: "+medicine);
        System.out.println("N got message");
        helper.getManager().notify(1,nb.build());
        System.out.println("N started to be notified");
    }

}
