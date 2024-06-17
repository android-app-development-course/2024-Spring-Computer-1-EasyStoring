package com.example.easystoring.logic.network

import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.easystoring.EasyStoringApplication
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.util.concurrent.TimeUnit


class NetworkService {
    companion object {
        val httpClient = OkHttpClient().newBuilder().connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).build()
        val baseURL = "http://1.15.173.30:8997"
    }

    fun userLogin(name: String, password: String): Boolean {
        var statusCode = ""
        var userInformation: Map<String, String>? = null
        var canLogin = false
        GlobalScope.launch {
            val getRequest =
                Request.Builder().url("$baseURL/checkUser").header("username", name).get()
                    .build()
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
                Log.d("2333", "Log in status $statusCode")
                if (userInformation != null)
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
                        if (password == it.get("password")) {
                            canLogin = true
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "登录成功",
                                Toast.LENGTH_SHORT
                            ).show()
                            Log.d("2333", "canLogin in Service $canLogin")
                        } else Toast.makeText(
                            EasyStoringApplication.context,
                            "用户名或密码错误",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                else -> {
                    Toast.makeText(
                        EasyStoringApplication.context,
                        "数据库错误",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
            Looper.loop()
        }
        return canLogin
    }

    fun userRegister(name: String, password: String) {
        var statusCode = ""
        var userInformation = mapOf("username" to name, "password" to password)
        GlobalScope.launch {
            val getRequest =
                Request.Builder().url("$baseURL/checkUser").header("username", name).get().build()
            val call = httpClient.newCall(getRequest)
            var response: Response? = null
            try {
                response = withContext(Dispatchers.IO) {
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
                    Log.d("2333", statusCode)
                }

                Looper.prepare()
                when (statusCode) {
                    "0" -> {
                        delay(100)
                        val jsonString = Gson().toJson(userInformation)
                        val jsonBody =
                            jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
                        val jsonRequest =
                            Request.Builder().url("$baseURL/registerUser").post(jsonBody).build()
                        val call = httpClient.newCall(jsonRequest)
                        var registerResponse: Response? = null
                        try {
                            registerResponse = withContext(Dispatchers.IO) {
                                call.execute()
                            }
                            registerResponse.body?.string()?.let {
                                Log.d("2333", it)
                                val response: MutableMap<*, *> = Gson().fromJson(
                                    it,
                                    MutableMap::class.java
                                )
                                statusCode = response.get("StatusCode").toString()
                                Log.d("2333", statusCode)
                                if (statusCode == "1")
                                    Toast.makeText(
                                        EasyStoringApplication.context,
                                        "注册成功",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                else
                                    Toast.makeText(
                                        EasyStoringApplication.context,
                                        "注册失败",
                                        Toast.LENGTH_SHORT
                                    ).show()
                            }
                        } catch (e: Exception) {
                            Log.d("2333", e.message!!)
                        }
                    }

                    "1" -> {
                        userInformation?.let {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "该用户已存在，请直接登录",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    else -> {
                        Toast.makeText(
                            EasyStoringApplication.context,
                            "数据库错误",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
                Looper.loop()
            } catch (e: Exception) {
                Log.d("2333", e.message!!)
            }
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