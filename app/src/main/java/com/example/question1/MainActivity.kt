package com.example.question1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {
    val ONESIGNAL_APP_ID = "49694912-190d-4234-ac37-62ffc689b388"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val secondActivityBtn = findViewById<Button>(R.id.secondActivityBtn)
        secondActivityBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)

            // Logging set to help debug issues, remove before releasing your app.
            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

            // OneSignal Initialization
            OneSignal.initWithContext(this)
            OneSignal.setAppId(ONESIGNAL_APP_ID)

            OneSignal.addTrigger("trigger", true)
        }
    }
}