package com.example.lunchbox


import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast
import com.example.lunchbox.R


class MusicService : Service() {
    var myPlayer: MediaPlayer? = null
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {

        myPlayer = MediaPlayer.create(this, R.raw.gold)

        //setting loop play to true
        //this will make the ringtone continuously playing        myPlayer.setLooping(false); // Set looping
    }

    override fun onStart(intent: Intent, startid: Int) {

        myPlayer!!.start()
    }

    override fun onDestroy() {

        myPlayer!!.stop()
    }
}