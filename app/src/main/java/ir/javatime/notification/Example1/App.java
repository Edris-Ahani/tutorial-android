package ir.javatime.notification.Example1;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //to create notification channel

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel =
                    new NotificationChannel("notif1",
                            "default channel", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("this is default channel");
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            if(notificationManager != null)
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
