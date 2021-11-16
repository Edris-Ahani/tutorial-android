package ir.javatime.tutorial_android_services.session3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import ir.javatime.tutorial_android_services.session1.MyService;

public class MyService3 extends Service {

    private IBinder myBinder = new MyBinder();

    public MyService3() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder;
    }

    public class MyBinder extends Binder{
        public MyService3 getService(){
            return MyService3.this;
        }
    }

    public String message(){
        return "Hello Bound Service";
    }
}