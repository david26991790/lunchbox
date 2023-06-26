package com.example.lunchbox
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Credits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits)
    }
    fun go_mainpage() {
        var intent = Intent(this, MainPage::class.java)
    }

    fun gomainpage(v: View) {
        var intent = Intent(this, MainPage::class.java)
        startActivity((intent))
    }
}