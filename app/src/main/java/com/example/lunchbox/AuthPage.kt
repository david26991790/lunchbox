package com.example.lunchbox
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AuthPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authpage)
    }

    fun go_mainpage(v: View) {
        var intent = Intent(this, MainPage::class.java)
        startActivity(intent)
    }
    fun go_authidea(){
        val intent = Intent(this, authideaActivity::class.java)
        startActivity(intent)
    }
    fun goauthidea(v: View){
        val intent = Intent(this, authideaActivity::class.java)
        startActivity(intent)
    }
    fun authgithub(v: View) {
        val uri = Uri.parse("https://github.com/david26991790")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    }
