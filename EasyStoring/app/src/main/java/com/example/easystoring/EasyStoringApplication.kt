package com.example.easystoring

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class EasyStoringApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        // 当前登录用户ID
        lateinit var userID: String
        lateinit var username: String
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}