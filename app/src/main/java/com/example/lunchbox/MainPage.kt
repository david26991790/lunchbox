package com.example.lunchbox

import BackgroundMusicService
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi

class MainPage : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBackgroundMusicService()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startBackgroundMusicService() {
        val backgroundMusicServiceIntent = Intent(this, BackgroundMusicService::class.java)
        startForegroundService(backgroundMusicServiceIntent)
    }

    fun go_random() {
        startActivity(Intent(this, Lunchrandom::class.java))
    }

    fun gorandom(v: View) {
        go_random()
    }

    fun go_school() {
        startActivity(Intent(this, Schoolpage::class.java))
    }

    fun goschool(v: View) {
        go_school()
    }

    fun go_lunch() {
        startActivity(Intent(this, Lunchlist::class.java))
    }

    fun golunch(v: View) {
        go_lunch()
    }

    fun go_auth() {
        startActivity(Intent(this, AuthPage::class.java))
    }

    fun goauth(v: View) {
        go_auth()
    }

    fun go_credit() {
        startActivity(Intent(this, Credits::class.java))
    }

    fun gocredit(v: View) {
        go_credit()
    }
}