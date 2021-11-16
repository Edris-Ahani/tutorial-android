package ir.javatime.tutorial_android_services.session3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Time;

import ir.javatime.tutorial_android_services.R;

public class MainActivity3 extends AppCompatActivity {

    public static String TAG = MainActivity3.class.getName();

    Button btn;

    Intent intent;
    ServiceConnection serviceConnection;
    MyService3 myService3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn = findViewById(R.id.main_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myService3 != null){
                    Toast.makeText(myService3, myService3.message(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i(TAG, "onServiceConnected: ");
                MyService3.MyBinder myBinder = (MyService3.MyBinder) service;
                myService3 = myBinder.getService();

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i(TAG, "onServiceDisconnected: " + name);
                myService3 = null;
            }
        };
        intent = new Intent(this, MyService3.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //unbindService(serviceConnection);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);
    }
}