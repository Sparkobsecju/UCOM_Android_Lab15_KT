package com.example.lab15_kt

import android.app.IntentService
import android.content.Intent

class EchoIntentService: IntentService(EchoService::class.java.simpleName) {
    override fun onHandleIntent(intent: Intent?) {
        TODO("Not yet implemented")
    }
}