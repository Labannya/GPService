package com.example.newpc.myapplication;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

/**
 * Created by NewPC on 21/04/2018.
 */

public class NotificationHelper extends ContextWrapper {

    public static final String channel1ID="Channel1ID";
    public static final String channelName="Channel 1";
    public NotificationManager manager;
    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createChannels();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel channel = new NotificationChannel(channel1ID,channelName, NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableVibration(true);
        channel.enableLights(true);
        channel.setLightColor(R.color.colorPrimary);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager(){
        if(manager == null){
            manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        System.out.println("N manager not null");
        return manager;
    }

    public NotificationCompat.Builder getChannel1Notification(String title, String message){
        System.out.println("N started and got channel");
        return new NotificationCompat.Builder(getApplicationContext(),channel1ID)
               .setContentTitle(title)
                .setContentText(message)
               .setSmallIcon(R.drawable.alarm);

    }

}
