package com.example.lab15_kt

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class EchoService: Service() {

    private var flag = false

    companion object {
        const val TAG = "ECHO"
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        Log.v(TAG, "一次性的啟動")
    }

    override fun onDestroy() {
        Log.v(TAG, "一次性的銷毀")
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        Log.v(TAG, "啟動的id: $startId")
        flag = true
        doEcho(startId)
        return super.onStartCommand(intent, flags, startId)
    }

    private fun doEcho(startId: Int) {
        Thread{
            for (count in 1..10) {
                Log.v(TAG, "啟動的id: $startId, 計數: $count")
                Thread.sleep(500)
                if (flag) {
                    break
                }
            }
        }.start()
    }


}