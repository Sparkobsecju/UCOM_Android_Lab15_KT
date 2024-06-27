package com.example.lab15_kt

import android.app.IntentService
import android.content.Intent
import android.util.Log


class EchoIntentService: IntentService(EchoService::class.java.simpleName) {
    override fun onHandleIntent(intent: Intent?) {
        TODO("Not yet implemented")
    }

    private var flag = false

    private fun doEcho(startId: Int) {
        Thread{
            for (count in 1..10) {
                Log.v(EchoService.TAG, "啟動的id: $startId, 計數: $count")
                Thread.sleep(500)
                if (flag) {
                    break
                }
            }
        }.start()
    }
}