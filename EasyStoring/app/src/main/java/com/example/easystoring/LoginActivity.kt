package com.example.easystoring

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.easystoring.databinding.ActivityLoginBinding
import com.example.easystoring.logic.network.NetworkService
import com.example.easystoring.logic.network.NetworkService.Companion.baseURL
import com.example.easystoring.logic.network.NetworkService.Companion.httpClient
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            try {
                if (binding.password.text.toString() != "" && binding.username.text.toString() != "") {
                    runBlocking {
                        var userInformation: Map<String, Any>? = null
                        var statusCode = async {
                            var temp = ""
                            runBlocking {
                                val getRequest =
                                    Request.Builder().url("${NetworkService.baseURL}/checkUser")
                                        .header("username", binding.username.text.toString()).get()
                                        .build()
                                val call = NetworkService.httpClient.newCall(getRequest)
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
                                    temp = response.get("StatusCode").toString()
                                    if (temp == "1")
                                        userInformation =
                                            response.get("Message") as Map<String, String>?
                                    Log.d("2333", "Log in status $temp")
//                                if (userInformation != null)
//                                    for ((key, value) in userInformation!!)
//                                        Log.d("2333", "$key $value")
                                }
                            }
                            temp
                        }.await()
                        Log.d("2333", "status code $statusCode")
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
                                    if (binding.password.text.toString() == it["password"] && it["userId"] != null) {
                                        var userID: String =
                                            if (it["userId"] is String) it["userId"] as String
                                            else (it["userId"] as Double).toInt().toString()
                                        EasyStoringApplication.userID = userID
                                        EasyStoringApplication.username = it["username"] as String
                                        Log.d("2333", "userID: $userID")
                                        Log.d(
                                            "2333",
                                            "username: ${EasyStoringApplication.username}"
                                        )
                                        Toast.makeText(
                                            EasyStoringApplication.context,
                                            "登录成功",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        val intent =
                                            Intent(
                                                EasyStoringApplication.context,
                                                MainActivity::class.java
                                            )
                                        startActivity(intent)
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
                    }
                } else Toast.makeText(this, "用户名和密码不可为空", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "登录失败 请重试", Toast.LENGTH_SHORT).show()
                Log.d("2333", "Log in error ${e.message}")
            }
        }

        binding.registerButton.setOnClickListener {
            try {
                if (binding.password.text.toString() != "" && binding.username.text.toString() != "") {
//                    registerCheck(
//                        binding.username.text.toString(),
//                        binding.password.text.toString()
//                    )
                    try {
                        var statusCode = ""
                        var userInformation = mapOf(
                            "username" to binding.username.text.toString(),
                            "password" to binding.password.text.toString()
                        )
                        GlobalScope.launch {
                            val getRequest =
                                Request.Builder().url("$baseURL/checkUser")
                                    .header("username", binding.username.text.toString())
                                    .get()
                                    .build()
                            val call = httpClient.newCall(getRequest)
                            var response: Response? = null
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
                                        Request.Builder().url("$baseURL/registerUser")
                                            .post(jsonBody)
                                            .build()
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
                                        Log.d("error 2333", e.message!!)
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

                        }
                    } catch (e: Exception) {
                        for(i in e.stackTrace)
                        Log.d("error1 2333", "$i")
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
                else Toast.makeText(this, "用户名和密码不可为空", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "注册失败 请重试", Toast.LENGTH_SHORT).show()
                Log.d("error2 2333", "Register error ${e.message}")
            }
        }
    }

    private fun loginCheck(name: String, password: String): Boolean {
        return NetworkService().userLogin(name, password)
    }

    private fun registerCheck(name: String, password: String) {
        NetworkService().userRegister(name, password)
    }
}