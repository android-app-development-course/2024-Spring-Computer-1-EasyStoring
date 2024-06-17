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

        // 所有Items和Cupboards,全局变量
        var items: List<Map<String, Any>>? = null
        var cupboards: List<Map<String, Any>>? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}