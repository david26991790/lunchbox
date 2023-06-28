package com.example.lunchbox

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.os.Build

import androidx.core.app.NotificationCompat


class MusicService : Service() {
    private var myPlayer: MediaPlayer? = null
    private val NOTIFICATION_ID = 1
    private val CHANNEL_ID = "MusicServiceChannel"
    private lateinit var closeAppReceiver: BroadcastReceiver

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        myPlayer = MediaPlayer.create(this, R.raw.gold)
        myPlayer?.isLooping = true
        registerCloseAppReceiver()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(NOTIFICATION_ID, createNotification())
        myPlayer?.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterCloseAppReceiver()
        myPlayer?.stop()
        myPlayer?.release()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Music Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    private fun createNotification(): Notification {
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("午餐小精靈")
            .setContentText("黃金傳說")
            .setSmallIcon(R.drawable.no_image_box)
            .build()
    }

    private fun registerCloseAppReceiver() {
        val filter = IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)
        closeAppReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS == intent?.action) {
                    stopSelf()
                }
            }
        }
        registerReceiver(closeAppReceiver, filter)
    }

    private fun unregisterCloseAppReceiver() {
        unregisterReceiver(closeAppReceiver)
    }
}