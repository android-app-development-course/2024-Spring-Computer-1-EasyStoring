package com.example.easystoring.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.Item
import com.example.easystoring.ItemAdapter
import com.example.easystoring.databinding.FragmentHomeBinding
import com.example.easystoring.logic.model.AppDBHelper
import com.example.easystoring.logic.model.DBShow
import com.example.easystoring.logic.network.NetworkService
import com.example.easystoring.ui.AdditemActivity.AddActivity
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val ItemList = ArrayList<Item>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // 测试数据库是否正常
        val showSQLite = binding.showSQLite
        showSQLite.setOnClickListener {
            startActivity(Intent(requireContext(), DBShow::class.java))
//            Toast.makeText(requireContext(),"1111",Toast.LENGTH_SHORT).show()
        }
        initItem()
        val recyclerView: RecyclerView = binding.recyclerView
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        val adapter = ItemAdapter(ItemList)     // 在这里修改物品栏显示的内容
        recyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            startActivity(Intent(EasyStoringApplication.context, AddActivity::class.java))
        }


        homeViewModel.text.observe(viewLifecycleOwner) {

        }

        // 所有Items和Cupboards,全局变量
        var items: List<Map<String, Any>>? = null
        var cupboards: List<Map<String, Any>>? = null

        binding.button4.setOnClickListener {
            val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
            val db = dbHelper.writableDatabase
            val allCupboards = dbHelper.getAllRowsFromMyTable(db, "Cupboard")
            val allItems = dbHelper.getAllRowsFromMyTable(db, "Item")
            for (i in allItems)
                Log.d("2333", i.toString())
            for (i in allCupboards)
                Log.d("2333", i.toString())
            // 同步Items
            try {
                runBlocking {
                    var statusCode = async {
                        var temp = ""
                        runBlocking {
                            val jsonString = Gson().toJson(allItems)
                            val jsonBody =
                                jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
                            val postRequest =
                                Request.Builder().url("${NetworkService.baseURL}/syncFromDevice")
                                    .header("userID", "1").header("tableName", "Items")
                                    .post(jsonBody)
                                    .build()
                            val call = NetworkService.httpClient.newCall(postRequest)
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
                                Log.d("2333", "SyncFromDevice status $temp")
                                response.get("Message")?.toString().let {
                                    Log.d("2333", "SyncFromDevice message $it")
                                }
                            }
                        }
                        temp
                    }.await()
                    when (statusCode) {
                        "0" -> {
                            Toast.makeText(
                                EasyStoringApplication.context,
                                "云同步到服务器失败",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }

                        "1" -> {
                            // 同步Cupboards
                            delay(100)
                            runBlocking {
                                var statusCode = async {
                                    var temp = ""
                                    runBlocking {
                                        val jsonString = Gson().toJson(allCupboards)
                                        val jsonBody =
                                            jsonString.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
                                        val postRequest =
                                            Request.Builder()
                                                .url("${NetworkService.baseURL}/syncFromDevice")
                                                .header("userID", "1")
                                                .header("tableName", "Cupboards")
                                                .post(jsonBody)
                                                .build()
                                        val call = NetworkService.httpClient.newCall(postRequest)
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
                                            Log.d("2333", "SyncFromDevice status $temp")
                                            response.get("Message")?.toString().let {
                                                Log.d("2333", "SyncFromDevice message $it")
                                            }
                                        }
                                    }
                                    temp
                                }.await()
                                when (statusCode) {
                                    "0" -> {
                                        Toast.makeText(
                                            EasyStoringApplication.context,
                                            "云同步到服务器失败",
                                            Toast.LENGTH_SHORT
                                        )
                                            .show()
                                    }

                                    "1" -> {
                                        Toast.makeText(
                                            EasyStoringApplication.context,
                                            "云同步到服务器成功",
                                            Toast.LENGTH_SHORT
                                        ).show()
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
            } catch (e: Exception) {
                Log.d("2333", "Exception: ${e.message}")
            }
        }

        binding.button5.setOnClickListener {
            try {
                runBlocking {
                    var itemsResponse = async {
                        var res: MutableMap<*, *>? = null
                        runBlocking {
                            val getRequest =
                                Request.Builder().header("userID", "1").header("tableName", "Items")
                                    .url("${NetworkService.baseURL}/syncFromServer")
                                    .get()
                                    .build()
                            val call = NetworkService.httpClient.newCall(getRequest)
                            val response = withContext(Dispatchers.IO) {
                                call.execute()
                            }
                            Log.d("2333", response.toString())
                            response.body?.string()?.let {
                                Log.d("2333", it)
                                res = Gson().fromJson(
                                    it,
                                    MutableMap::class.java
                                )
                            }
                        }
                        res
                    }.await()
                    if (itemsResponse == null) {
                        Log.d("2333", "Null response in syncFromServer")
                        Toast.makeText(
                            EasyStoringApplication.context,
                            "云同步到设备失败",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else {
                        val statusCode = itemsResponse["StatusCode"]
                        val message = itemsResponse["Message"]
                        Log.d("2333", "syncFromServer status code: $statusCode, message: $message")
                        when (statusCode) {
                            "0" -> {
                                Toast.makeText(
                                    EasyStoringApplication.context,
                                    "云同步到设备失败",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }

                            "1" -> {
                                // 服务器拉取的当前用户ID的所有Items
                                items = itemsResponse["Data"]?.let {
                                    it as List<Map<String, Any>>
                                }
                                delay(100)
                                // 拉取当前用户ID的所有Cupboards
                                runBlocking {
                                    var cupboardsResponse = async {
                                        var res: MutableMap<*, *>? = null
                                        runBlocking {
                                            val getRequest =
                                                Request.Builder().header("userID", "1")
                                                    .header("tableName", "Cupboards")
                                                    .url("${NetworkService.baseURL}/syncFromServer")
                                                    .get()
                                                    .build()
                                            val call = NetworkService.httpClient.newCall(getRequest)
                                            val response = withContext(Dispatchers.IO) {
                                                call.execute()
                                            }
                                            Log.d("2333", response.toString())
                                            response.body?.string()?.let {
                                                Log.d("2333", it)
                                                res = Gson().fromJson(
                                                    it,
                                                    MutableMap::class.java
                                                )
                                            }
                                        }
                                        res
                                    }.await()
                                    if (cupboardsResponse == null) {
                                        Log.d("2333", "Null response in syncFromServer")
                                        Toast.makeText(
                                            EasyStoringApplication.context,
                                            "云同步到设备失败",
                                            Toast.LENGTH_SHORT
                                        )
                                            .show()
                                    } else {
                                        val statusCode = cupboardsResponse["StatusCode"]
                                        val message = cupboardsResponse["Message"]
                                        Log.d(
                                            "2333",
                                            "syncFromServer status code: $statusCode, message: $message"
                                        )
                                        when (statusCode) {
                                            "0" -> {
                                                Toast.makeText(
                                                    EasyStoringApplication.context,
                                                    "云同步到设备失败",
                                                    Toast.LENGTH_SHORT
                                                )
                                                    .show()
                                            }

                                            "1" -> {
                                                cupboards = cupboardsResponse["Data"]?.let {
                                                    it as List<Map<String, Any>>
                                                }
                                                if (cupboards != null) {
                                                    Toast.makeText(
                                                        EasyStoringApplication.context,
                                                        "云同步到设备成功",
                                                        Toast.LENGTH_SHORT
                                                    )
                                                        .show()
                                                } else
                                                    Toast.makeText(
                                                        EasyStoringApplication.context,
                                                        "云同步到设备失败",
                                                        Toast.LENGTH_SHORT
                                                    )
                                                        .show()
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
                }
            } catch (e: Exception) {
                Log.d("2333", "Exception: ${e.message}")
            }
            if (items != null && cupboards != null) {
                for (i in items!!)
                    Log.d("2333", "$i")
                for (i in cupboards!!)
                    Log.d("2333", "$i")
            }
        }

        return root
    }

    // 从数据库中读取物品信息
    @SuppressLint("Range")
    private fun initItem() {
        val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM Item WHERE userId = ?", arrayOf("1"))

        var ItemNum = 0
        // 遍历查询结果
        if (cursor.moveToFirst()) {
            do {
                ItemNum++
                val item1: Item = Item(1)
                item1.id = ItemNum
                try {
                    item1.userId = cursor.getInt(cursor.getColumnIndex("userId"))
                    item1.name = cursor.getString(cursor.getColumnIndex("name"))
                    item1.imageId = cursor.getString(cursor.getColumnIndex("imageId"))
                    item1.cupboardId = cursor.getString(cursor.getColumnIndex("cupboardId")).toInt()
                    item1.productionDate = cursor.getString(cursor.getColumnIndex("productionDate"))
                    item1.number = cursor.getString(cursor.getColumnIndex("number")).toInt()
                    ItemList.add(item1)
                } catch (e: Exception) {
                    Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
                }
            } while (cursor.moveToNext())
        }

        // 关闭游标和数据库
        cursor.close()
        db.close()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}