package ir.javatime.tutorial_android_services.session2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.util.Timer;
import java.util.TimerTask;

import ir.javatime.tutorial_android_services.session1.MyService;

//foreground service
public class MyService2 extends Service {
    //to check service run in background
    /*
    adb shell dumpsys activity services
    adb shell service list
    */


    public static String TAG = MyService.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();


        stopForeground(true);
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //can return this values
        /*
        START_STICKY
        START_NOT_STICKY
        START_REDELIVER_INTENT
        */
        startForeground(1456, createNotification());

        //do your work here
        try {
            Thread.sleep(5000);
            stopSelf();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return null;
    }


    private Notification createNotification(){
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(notificationManager == null){
            return null;
        }
        //to create channel
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel =
                    new NotificationChannel("app_default", "Default",
                            NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        Notification notification = new NotificationCompat.Builder(
                this,
                "app_default"
        )
                .setSmallIcon(android.R.drawable.stat_notify_chat)
                .setContentTitle("Foreground Service")
                .setContentText("My service is running...")
                .build();
        return notification;
    }
}