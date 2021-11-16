package ir.javatime.tutorial_android_services.session1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

//background service
public class MyService extends Service {

    //to check service run in background
    /*
    adb shell dumpsys activity services
    adb shell service list
    */


    public static String TAG = MyService.class.getName();
    public int serviceValue = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: " + serviceValue);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: " + serviceValue);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //can return this values
        /*
        START_STICKY
        START_NOT_STICKY
        START_REDELIVER_INTENT
        */


        //do your work here
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.i(TAG, "run: " + serviceValue);
                serviceValue++;
                if(serviceValue == 5){
                    cancel();
                    stopSelf();
                }
            }
        }, 0, 1000);

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return null;
    }
}
