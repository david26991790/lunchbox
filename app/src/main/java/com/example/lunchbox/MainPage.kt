package com.example.lunchbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 創建 Intent 以啟動 BackgroundMusicService
        var backgroundMusicServiceIntent = Intent(this, BackgroundMusicService::class.java)

        // 在 onCreate 方法中啟動 BackgroundMusicService
        startService(backgroundMusicServiceIntent)
    }

    fun go_random() {
        var intent = Intent(this, Lunchrandom::class.java)
    }

    fun gorandom(v: View) {
        var intent = Intent(this, Lunchrandom::class.java)
        startActivity((intent))
    }


    }


