package com.example.lunchbox

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class BackgroundMusicService : Service() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.food)
        mediaPlayer?.isLooping = true
        mediaPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}