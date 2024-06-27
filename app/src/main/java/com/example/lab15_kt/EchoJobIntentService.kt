package com.example.lab15_kt

import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class EchoJobIntentService: JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        for (count in 1..10) {
            Thread.sleep(500)
            Log.v(EchoService.TAG, "on job intent service, count=${count}")
        }
    }

    private fun enqueue(, work: Intent) {

    }
}