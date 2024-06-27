package com.example.lab15_kt

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class EchoService : Service() {
    var isRunning = false

    companion object {
        const val TAG = "ECHO";
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Log.v(TAG, "一次性的起動")
        isRunning = true
    }

    override fun onDestroy() {
        isRunning = false
        Log.v(TAG, "一次性的清除")
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //Log.v(TAG,"起動的id是${startId}")
        doEcho(startId)
        return super.onStartCommand(intent, flags, startId)
    }

    private fun doEcho(startId: Int) {
        Thread() {
            for (count in 1..10) {

                Log.v(TAG, "起動的id是${startId}, 第${count}個")
                Thread.sleep(500)
                if (!isRunning) {
                    break
                }
            }
        }.start()

    }
}