package com.example.lunchbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class gameinfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameinfo)
    }
    fun go_mainpage(v: View) {
        var intent = Intent(this, MainPage::class.java)
        startActivity((intent))
    }
}