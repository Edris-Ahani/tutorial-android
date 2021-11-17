package ir.javatime.notification.Example1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ir.javatime.notification.R;

public class MainActivity extends AppCompatActivity {

    Button btn_simple_notif, btn_big_picture_style, btn_big_text_style,
            btn_inbox_style;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_simple_notif = findViewById(R.id.btn_simple_notif);
        btn_big_picture_style = findViewById(R.id.btn_big_picture_style);
        btn_big_text_style = findViewById(R.id.btn_big_text_style);
        btn_inbox_style = findViewById(R.id.btn_inbox_style);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        btn_simple_notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                        Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent =
                        PendingIntent.getActivity(MainActivity.this,
                                0, intent, 0);
                Notification notification =
                        new NotificationCompat.Builder(MainActivity.this, "notif1")
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setLargeIcon(BitmapFactory.decodeResource(
                                getResources(),
                                R.mipmap.ic_launcher
                        ))
                        .setContentTitle("Title Notif1")
                        .setContentText("this is content text")
                        .setContentIntent(pendingIntent)
                        .build();
                notificationManager.notify(1456, notification);

            }
        });
        btn_big_picture_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification bigPictureNotification =
                        new NotificationCompat.Builder(MainActivity.this, "notif1")
                                .setSmallIcon(android.R.drawable.stat_notify_chat)
                                .setLargeIcon(BitmapFactory.decodeResource(
                                        getResources(),
                                        R.mipmap.ic_launcher
                                ))
                                .setContentTitle("Title Notif1")
                                .setContentText("this is content text")
                                .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(
                                        BitmapFactory.decodeResource(getResources(),R.drawable.user)
                                )
                                .setBigContentTitle("content title"))
                                .build();
                notificationManager.notify(1467, bigPictureNotification);
            }
        });

        btn_big_text_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification bigTextStyleNotification =
                        new NotificationCompat.Builder(MainActivity.this, "notif1")
                                .setSmallIcon(android.R.drawable.stat_notify_chat)
                                .setContentTitle("Title Notif1")
                                .setContentText("this is content text")
                                .setStyle(new NotificationCompat.BigTextStyle().bigText("this is a long text. this is a long text. this is a long text. this is a long text. this is a long text. this is a long text.")
                                .setBigContentTitle("set big content title"))
                                .build();
                notificationManager.notify(1356, bigTextStyleNotification);
            }
        });


        btn_inbox_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification inboxStyle =
                        new NotificationCompat.Builder(MainActivity.this, "notif1")
                                .setSmallIcon(android.R.drawable.stat_notify_chat)
                                .setContentTitle("Title Notif1")
                                .setContentText("this is content text")
                                .setStyle(new NotificationCompat.BigTextStyle().bigText("this is a long text. this is a long text. this is a long text. this is a long text. this is a long text. this is a long text.")
                                        .setBigContentTitle("set big content title"))
                                .setStyle(new NotificationCompat.InboxStyle()
                                .addLine("this is line1")
                                .addLine("this is line2")
                                .addLine("this is line3"))
                                .build();
                notificationManager.notify(1789, inboxStyle);
            }
        });


    }


    public void bigPictureStyle(){

    }
}