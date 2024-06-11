package com.example.easystoring.ui.TestFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.easystoring.databinding.FragmentTestBinding
import com.example.easystoring.logic.network.NetworkService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException
import kotlin.concurrent.thread

class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }

    private val viewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTestBinding.inflate(layoutInflater)
        val url = "http://1.15.173.30:8997/getUsername"

        binding.button.setOnClickListener {
            val map = mutableMapOf<String, String>()
            map["username"] = "Cecilia"
            map["password"] = "12412344"
            val jsonString = Gson().toJson(map)
//            val request = Request.Builder().url(url).header("UserInformation",map.toString()).get().build()
            val jsonBody =
                jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
            val jsonRequest = Request.Builder().url(url).post(jsonBody).build()
            val call = NetworkService.httpClient.newCall(jsonRequest)
            thread {
                try {
                    val response = call.execute()
                    response.body?.string()?.let { it1 -> Log.d("2333", it1) }
                } catch (e: IOException) {
                    e.message?.let { Log.d("2333", it) }
                }
            }
        }

        binding.button3.setOnClickListener {
//            val map = mutableMapOf<String, String>()
//            map["username"]="Cecilia"
//            map["password"]="12412344"
//            val jsonString=Gson().toJson(map)
////            val request = Request.Builder().url(url).header("UserInformation",map.toString()).get().build()
//            val jsonBody=
//                jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
//            val jsonRequest=Request.Builder().url(url).post(jsonBody).build()
//            val call = NetworkService.httpClient.newCall(jsonRequest)
            val getRequest =
                Request.Builder().url(NetworkService.baseURL + "/getlist").get().build()
            val getCall = NetworkService.httpClient.newCall(getRequest)

            thread {
                try {
                    val response = getCall.execute()
                    response.body?.string()?.let {
                        Log.d("2333", it)
                        val map: MutableMap<*, *> = Gson().fromJson(
                            it,
                            MutableMap::class.java
                        )
                        for ((key,value ) in map)
                            Log.d("2333","${key!!::class.java} ${value!!::class.java}")
                    }
                } catch (e: IOException) {
                    e.message?.let { Log.d("2333", it) }
                }
            }
        }

        return binding.root
//        return inflater.inflate(R.layout.fragment_test, container, false)
    }
}