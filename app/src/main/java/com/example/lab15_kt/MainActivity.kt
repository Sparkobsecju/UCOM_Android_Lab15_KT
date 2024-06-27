package com.example.lab15_kt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        const val MESSAGE = "message"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val echoServiceIntent = Intent(this, EchoService::class.java)
        findViewById<Button>(R.id.button1).setOnClickListener {
            echoServiceIntent.putExtra(MESSAGE, System.currentTimeMillis().toString())
            startService(echoServiceIntent)
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            stopService(echoServiceIntent)
        }
        val echoIntentServiceIntent = Intent(this, EchoIntentService::class.java)
        findViewById<Button>(R.id.button3).setOnClickListener {
            echoIntentServiceIntent.putExtra(MESSAGE,System.currentTimeMillis().toString() )
            startService(echoIntentServiceIntent)
        }

    }
}