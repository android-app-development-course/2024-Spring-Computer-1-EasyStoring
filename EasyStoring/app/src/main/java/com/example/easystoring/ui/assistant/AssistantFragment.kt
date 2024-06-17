package com.example.easystoring.ui.assistant

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.databinding.FragmentAssistantBinding
import com.example.easystoring.logic.network.NetworkService
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.Request
import okhttp3.Response
import java.net.URLDecoder
import java.net.URLEncoder

class AssistantFragment : Fragment() {

    companion object {
        fun newInstance() = AssistantFragment()
    }

    private var _binding: FragmentAssistantBinding? = null
    private val viewModel: AssistantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentAssistantBinding.inflate(layoutInflater)

        binding.generateButton.setOnClickListener {
            try {
                runBlocking {
                    var answer: Map<String, Any>? = null
                    var statusCode: String? = null
                    var response = async {
                        var temp: Response? = null
                        runBlocking {
                            // 需要EncodeURI为UTF-8格式
                            // 现在我想卖出一个二手${binding.textView10.text}，请写一个二手商品描述，要能吸引人购买
                            // 现在我想卖出一个二手${binding.textView10.text}，请写一个二手商品描述，要能吸引人购买，100字以内即可
                            val URLString = URLEncoder.encode(
                                "现在我想卖出一个二手${binding.textView10.text}，请写一个二手商品描述，要能吸引人购买，100字以内即可",
                                "utf-8"
                            )
                            Log.d("2333", "$URLString, ${URLDecoder.decode(URLString, "utf-8")}")
                            val getRequest =
                                Request.Builder().url("${NetworkService.baseURL}/askGPT")
                                    .header("content", URLString).header("GPTType", "SparkV3")
                                    .header("time", "2333").get()
                                    .build()
                            val call = NetworkService.httpClient.newCall(getRequest)
                            temp = withContext(Dispatchers.IO) {
                                call.execute()
                            }
                            Log.d("2333", temp.toString())
                        }
                        temp
                    }.await()
                    response?.body?.string()?.let {
                        Log.d("2333", it)
                        answer = Gson().fromJson(
                            it,
                            Map::class.java
                        ) as Map<String, Any>?
                        Log.d("2333", "AI generating answer: $answer")
                        binding.editTextTextMultiLine.setText(answer?.get("answer").toString())
                        statusCode = answer?.get("StatusCode").toString()
                    }
                    Log.d("2333", "status code $statusCode")
                    when (statusCode) {
                        "0" -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "生成失败",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }

                        "1" -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "生成成功",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }

                        else -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "服务器错误",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "生成失败 请重试", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
                Log.d("2333", "AI generating ${e.stackTrace}")
            }
        }

        binding.copyButton.setOnClickListener {
            val clipboard =
                requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip: ClipData =
                ClipData.newPlainText("Description", binding.editTextTextMultiLine.text)
            Log.d("2333", "copy content: ${binding.editTextTextMultiLine.text}")
            clipboard.setPrimaryClip(clip)
            Toast.makeText(requireContext(), "已复制到剪贴板", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}