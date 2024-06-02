package com.example.easystoring.logic.network

import com.example.easystoring.User
import retrofit2.Call
import retrofit2.http.GET

class App(val id: String, val name: String, val version: String)

class Username(val username:String,val message:String)
interface AppService {
    @GET("get_data.json")
    fun getAppData(): Call<List<App>>

    @GET("getUsername")
    fun getUsername():Call<List<Username>>
}