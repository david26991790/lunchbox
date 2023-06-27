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

    fun goscroll(v: View) {
        startActivity(Intent(this, ScrollActivity::class.java))
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