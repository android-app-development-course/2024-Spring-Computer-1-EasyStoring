package com.example.easystoring.logic.network

import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.MainActivity
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread


class NetworkService {
    companion object {
        val httpClient = OkHttpClient().newBuilder().connectTimeout(2, TimeUnit.SECONDS)
            .writeTimeout(2, TimeUnit.SECONDS).readTimeout(2, TimeUnit.SECONDS).build()
        val baseURL = "http://1.15.173.30:8997"
    }

    fun userRegister() {

    }

    fun userLogin(name: String, password: String) {
        var statusCode = ""
        var userInformation: Map<String, String>? = null
        GlobalScope.launch {
            val getRequest =
                Request.Builder().url(baseURL + "/checkUser").header("username", name).get().build()
            val call = httpClient.newCall(getRequest)
            val response = withContext(Dispatchers.IO) {
                call.execute()
            }
            Log.d("2333", response.toString())
            response.body?.string()?.let {
                Log.d("2333", it)
                val response: MutableMap<*, *> = Gson().fromJson(
                    it,
                    MutableMap::class.java
                )
                statusCode = response.get("StatusCode").toString()
                if (statusCode == "1")
                    userInformation =
                        response.get("Message") as Map<String, String>?
                Log.d("2333", statusCode)
                for ((key, value) in userInformation!!)
                    Log.d("2333", "$key $value")
            }
            Looper.prepare()
            when (statusCode) {
                "0" -> {
                    Toast.makeText(
                        EasyStoringApplication.context,
                        "该用户不存在",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                "1" -> {
                    userInformation?.let {
                        Toast.makeText(
                            EasyStoringApplication.context,
                            it.get("password"),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                "2" -> {
                    Toast.makeText(EasyStoringApplication.context, "数据库错误", Toast.LENGTH_SHORT)
                        .show()
                }
                else -> {}
            }
            Looper.loop()

        }
//        runBlocking {
//            val getRequest =
//                Request.Builder().url(baseURL + "/checkUser").header("username", name).get().build()
//            val call = httpClient.newCall(getRequest)
//            var statusCode = ""
//            var userInformation: Map<String, String>? = null
//            try {
//                val response = async { call.execute() }.await()
//
////                response.body?.string()?.let {
////                    Log.d("2333", it)
////                    val response: MutableMap<*, *> = Gson().fromJson(
////                        it,
////                        MutableMap::class.java
////                    )
////                    statusCode = async { response.get("StatusCode").toString() }.await()
////                    if (statusCode == "1")
////                        userInformation = async { response.get("Message") as Map<String, String>? }.await()
////                    Log.d("2333", userInformation.toString())
////                    Log.d("2333", statusCode)
////                }
//            } catch (e: IOException) {
//                e.message?.let { Log.d("2333", it) }
//            }
//            Log.d("2333", userInformation.toString())
//            Log.d("2333", statusCode)
//            when (statusCode) {
//                "0" -> {
//                    Toast.makeText(
//                        EasyStoringApplication.context,
//                        "该用户不存在",
//                        Toast.LENGTH_SHORT
//                    )
//                        .show()
//                }
//
//                "1" -> {
//                    userInformation?.let {
//                        Toast.makeText(
//                            EasyStoringApplication.context,
//                            it.get("password"),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//
//                "2" -> {
//                    Toast.makeText(EasyStoringApplication.context, "数据库错误", Toast.LENGTH_SHORT)
//                        .show()
//                }
//
//                else -> {}
//            }
//        }
    }

    fun syncFromServer() {

    }

    fun syncToDevice() {

    }
    // 返回表中所有数据
//    fun pushDB(table:String):List<Map<String, String>>
//    {
//        var tableData:List<>
//        return
//    }
}