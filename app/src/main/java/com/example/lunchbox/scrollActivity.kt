package com.example.lunchbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout

class scrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll)
        add()
    }

    private fun add() {
        var li: LayoutInflater = LayoutInflater.from(this)
        var v:View = li.inflate(R.layout.activity_lunchlist, null,false)
        var ll:LinearLayout = findViewById(R.id.ll)
        ll.addView(v)

        var tv_lunch:ImageView = v.findViewById(R.id.tv_n)
        tv_lunch.setImageResource(R.drawable.lunchbackground)
    }


}