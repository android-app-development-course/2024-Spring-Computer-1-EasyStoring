package com.example.easystoring

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.easystoring.databinding.ActivityLoginBinding
import com.example.easystoring.logic.network.NetworkService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.Request

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
                if (binding.password.text.toString() != "" && binding.username.text.toString() != "")
                    registerCheck(
                        binding.username.text.toString(),
                        binding.password.text.toString()
                    )
                else Toast.makeText(this, "用户名和密码不可为空", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Toast.makeText(this, "注册失败 请重试", Toast.LENGTH_SHORT).show()
                Log.d("2333", "Register error ${e.message}")
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