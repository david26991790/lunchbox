package com.example.lunchbox
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi

class MainPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        music()
    }
    fun music() {
        val intent = Intent(this, MusicService::class.java)
        startService(intent)
    }



    fun go_random(v: View) {
        startActivity(Intent(this, Lunchrandom::class.java))
    }

    fun go_school(v: View) {
        startActivity(Intent(this, Schoolpage::class.java))
    }

    fun go_scroll(v: View) {
        startActivity(Intent(this, ScrollActivity::class.java))
    }

    fun go_auth(v: View) {
        startActivity(Intent(this, AuthPage::class.java))
    }

    fun go_credit(v: View) {
        startActivity(Intent(this, Credits::class.java))
    }

}