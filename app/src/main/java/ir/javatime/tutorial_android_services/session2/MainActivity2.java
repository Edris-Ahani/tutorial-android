package ir.javatime.tutorial_android_services.session2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import ir.javatime.tutorial_android_services.R;
import ir.javatime.tutorial_android_services.session1.MyService;

//example for foreground service
public class MainActivity2 extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent = new Intent(this, MyService2.class);
        startService(intent);
    }
}