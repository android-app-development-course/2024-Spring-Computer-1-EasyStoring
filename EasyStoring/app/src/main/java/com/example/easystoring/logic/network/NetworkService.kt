package com.example.easystoring.logic.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class NetworkService {
    companion object {
        val httpClient = OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.SECONDS)
            .writeTimeout(2, TimeUnit.SECONDS).readTimeout(2, TimeUnit.SECONDS).build()
        val baseURL = "http://1.15.173.30:8997"
    }
    fun userRegister(){

    }
    fun userLogin(){

    }
    fun syncFromServer(){

    }
    fun syncToDevice(){

    }
}