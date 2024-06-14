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
    // 返回表中所有数据
//    fun pushDB(table:String):List<Map<String, String>>
//    {
//        var tableData:List<>
//        return
//    }
}