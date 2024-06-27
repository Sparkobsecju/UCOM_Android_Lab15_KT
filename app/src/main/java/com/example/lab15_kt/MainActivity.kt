package com.example.lab15_kt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val service = Intent(this, EchoService::class.java)
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            startService(service)
        }
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            stopService(service)
        }
        val intentService = Intent(this, EchoIntentService::class.java)
        val button3 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            stopService(intentService)
        }
    }
}