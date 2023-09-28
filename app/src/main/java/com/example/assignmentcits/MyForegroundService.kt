package com.example.assignmentcits

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Collections

class MyForegroundService() : Service() {
    val fragmentFratured = FragmentFratured()
    override fun onCreate() {
        super.onCreate()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val serviceChannel = NotificationChannel("CHANEL_ID_1","MyServiceChanel",NotificationManager.IMPORTANCE_HIGH)
            getSystemService(NotificationManager::class.java).createNotificationChannel(serviceChannel)
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread{
            while (true){
                Thread.sleep(10000)

               Collections.swap(Objects.name,0,10)
               Collections.swap(Objects.name,1,11)
               Collections.swap(Objects.name,2,12)

                Collections.swap(Objects.countryName,0,10)
                Collections.swap(Objects.countryName,1,11)
                Collections.swap(Objects.countryName,2,12)

                Collections.swap(Objects.website,0,10)
                Collections.swap(Objects.website,1,11)
                Collections.swap(Objects.website,2,12)


                CoroutineScope(Dispatchers.IO).launch {
                    fragmentFratured.showResponse(applicationContext)
                }
            }
        }.start()
        val pendingIntent: PendingIntent =
            Intent(this, MainActivity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(this, 0, notificationIntent,
                    PendingIntent.FLAG_IMMUTABLE)
            }

        val CHANNEL_DEFAULT_IMPORTANCE = "CHANEL_ID_1"
        val notification: Notification = Notification.Builder(this@MyForegroundService,CHANNEL_DEFAULT_IMPORTANCE).setContentTitle(getText(R.string.notification_title))
            .setContentText(getText(R.string.notification_message))
            .setSmallIcon(R.drawable.follower_icon)
            .setContentIntent(pendingIntent)
            .setTicker(getText(R.string.ticker_text))
            .setColor(resources.getColor(R.color.onItemSelectedColor))
            .setColorized(true)
            .build()
        startForeground(1,notification)
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}