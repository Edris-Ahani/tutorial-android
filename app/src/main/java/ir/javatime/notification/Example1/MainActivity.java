package ir.javatime.notification.Example1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import ir.javatime.notification.R;

public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getName();

    static String CHANNEL_ID = "notif1";
    Button btn_simple_notif, btn_big_picture_style, btn_big_text_style,
            btn_inbox_style, btn_custom_layout1, btn_notif1, btn_notif2
            ,btn_notif3;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        btn_simple_notif = findViewById(R.id.btn_simple_notif);
        btn_big_picture_style = findViewById(R.id.btn_big_picture_style);
        btn_big_text_style = findViewById(R.id.btn_big_text_style);
        btn_inbox_style = findViewById(R.id.btn_inbox_style);
        btn_custom_layout1 = findViewById(R.id.btn_custom_layout1);
        btn_notif1 = findViewById(R.id.btn_notif1);
        btn_notif2 = findViewById(R.id.btn_notif2);
        btn_notif3 = findViewById(R.id.btn_notif3);

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
        btn_custom_layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the layouts to use in the custom notification
                RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.notification_small);
                //RemoteViews notificationLayoutExpanded = new RemoteViews(getPackageName(), R.layout.notification_large);

                // Apply the layouts to the notification
                Notification customNotification = new NotificationCompat.Builder(MainActivity.this, "notif1")
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setContentTitle("Title Notif1")
                        .setContentText("this is content text")
                        .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                        .setCustomContentView(notificationLayout)
                        //.setCustomBigContentView(notificationLayoutExpanded)
                        .build();
                notificationManager.notify(1908, customNotification);
            }
        });

        btn_notif1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(R.drawable.user)
                        .setContentTitle("imageTitle")
                        .setContentText("imageDescription")
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.user))
                        .setStyle(new NotificationCompat.BigPictureStyle()
                                .bigPicture(BitmapFactory.decodeResource(getResources(),
                                        R.drawable.user))
                                .bigLargeIcon(null))
                        .build();
                notificationManager.notify(1908, notification);
            }
        });

        btn_notif2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(android.R.drawable.stat_notify_chat)
                        .setContentTitle("title")
                        .setContentText("text")
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.user))
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("this is big text.this is big text.this is big text." +
                                        "this is big text.this is big text.this is big text." +
                                        "this is big text.this is big text.this is big text." +
                                        "this is big text.this is big text.this is big text."))
                        .build();
                notificationManager.notify(1908, notification);
            }
        });

        btn_notif3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|
                        Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("MY_TAG", "result");
                PendingIntent pendingIntent1 =
                        PendingIntent.getActivity(MainActivity.this,
                                9874, intent, 0);
                PendingIntent pendingIntent2 =
                        PendingIntent.getActivity(MainActivity.this,
                                9888, intent, 0);
                PendingIntent pendingIntent3 =
                        PendingIntent.getActivity(MainActivity.this,
                                10988, intent, 0);

                Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                        // Show controls on lock screen even when user hides sensitive content.
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setSmallIcon(R.drawable.user)
                        // Add media control buttons that invoke intents in your media service
                        .addAction(R.drawable.ic_previous, "Previous", pendingIntent1) // #0
                        .addAction(R.drawable.ic_pause, "Pause", pendingIntent2)  // #1
                        .addAction(R.drawable.ic_next, "Next", pendingIntent3)     // #2
                        // Apply the media style template
                        /*.setStyle(new android.support.v4.media.app.Notification.MediaStyle()
                                .setShowActionsInCompactView(1 )
                                .setMediaSession(mediaSession.getSessionToken()))*/
                        .setContentTitle("Wonderful music")
                        .setContentText("My Awesome Band")
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.user))
                        .build();
                notificationManager.notify(1908, notification);
            }
        });




        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        String myTagValue = getIntent().getStringExtra("MY_TAG");
        Log.i(TAG, "onCreate: ");
    }
    
    /*public void notifBtn(View view){
        Toast.makeText(context, "test", Toast.LENGTH_SHORT).show();
    }*/

}