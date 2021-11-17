package ir.javatime.tutorial_android_services.session4;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//background service
public class MyService4 extends Service {



    public static String TAG = MyService4.class.getName();
    private IBinder myBinder = new MyService4.MyBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
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


        //do your work here


        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return null;
    }

    public class MyBinder extends Binder {
        public MyService4 getService(){
            return MyService4.this;
        }
    }

    public void startWebSocket(){
        try {
            ServerSocket server = new ServerSocket(7070);
            System.out.println("Server has started on 127.0.0.1:7070.\r\nWaiting for a connection...");
            Socket client = server.accept();
            System.out.println("A client connected.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
