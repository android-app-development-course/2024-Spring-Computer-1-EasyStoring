package com.example.easystoring.logic.model

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class NetworkService {
    companion object{
        val httpClient=OkHttpClient().newBuilder().connectTimeout(2,TimeUnit.SECONDS)
            .writeTimeout(2,TimeUnit.SECONDS).readTimeout(2,TimeUnit.SECONDS).build()
    }
}