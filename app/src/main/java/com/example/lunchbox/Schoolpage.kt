package com.example.lunchbox
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class Schoolpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schoolpage)

    }

    fun schoolinfo(v: View) {
        val uri = Uri.parse("https://www.tvdi.gov.taipei/Content_List.aspx?n=F4A8038F76E551B9")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)

    }

    fun schoolocate(v: View) {
        val uri = Uri.parse("https://www.tvdi.gov.taipei/cp.aspx?n=D09C7E47EC5BF759")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)

    }

    fun schoolclass(v: View) {
        val uri = Uri.parse("https://www.tvdi.gov.taipei/News.aspx?n=A0A874C46637EF1F&sms=78D644F2755ACCAA")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    fun schoolweb(v: View) {
        val uri = Uri.parse("https://www.tvdi.gov.taipei/Default.aspx")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    fun go_mainpage(v: View) {
        var intent = Intent(this, MainPage::class.java)
    }


}