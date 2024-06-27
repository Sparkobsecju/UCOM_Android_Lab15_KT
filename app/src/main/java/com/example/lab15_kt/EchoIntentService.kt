package com.example.lab15_kt

import android.app.IntentService
import android.content.Intent
import android.util.Log

class EchoIntentService : IntentService(EchoService::class.java.simpleName) {
    override fun onHandleIntent(intent: Intent?) {
        for (count in 1..10) {
            Thread.sleep(500)
            Log.v(EchoService.TAG, "on intent service, count=${count}")
        }
    }
}