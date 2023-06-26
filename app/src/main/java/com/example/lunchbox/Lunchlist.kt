package com.example.lunchbox
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Lunchlist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunchlist)
    }
    fun go_mainpage() {
        var intent = Intent(this, MainPage::class.java)
    }

    fun gomainpage(v: View) {
        var intent = Intent(this, MainPage::class.java)
        startActivity((intent))
    }
}