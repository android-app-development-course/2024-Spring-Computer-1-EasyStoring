package com.example.easystoring.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.Cupboard
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
    private val binding get() = _binding!!
    private val ItemList = ArrayList<Item>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    @SuppressLint("NotifyDataSetChanged")
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
        recyclerView = binding.recyclerView
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        adapter = ItemAdapter(requireContext(), ItemList)     // 在这里修改物品栏显示的内容
        recyclerView.adapter = adapter

        binding.addButton.setOnClickListener {
            startActivityForResult(Intent(EasyStoringApplication.context, AddActivity::class.java),1)
        }


        homeViewModel.text.observe(viewLifecycleOwner) {

        }

//        binding.button4.setOnClickListener {
//            val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
//            val db = dbHelper.writableDatabase
//            dbHelper.DeviceToSever(db)
//        }
//
//        binding.button5.setOnClickListener {
//            val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
//            val db = dbHelper.writableDatabase
//            dbHelper.SeverToDevice(db)
//            initItem()
//            adapter.notifyDataSetChanged() // 刷新RecyclerView的UI
//        }

        return root
    }

    // 从数据库中读取物品信息
    @SuppressLint("Range")
    private fun initItem() {
        ItemList.clear()
        val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM Item WHERE userId = ?", arrayOf(EasyStoringApplication.userID))

        var ItemNum = 0
        // 遍历查询结果
        if (cursor.moveToFirst()) {
            do {
                ItemNum++
                val item1: Item = Item(EasyStoringApplication.userID.toInt())
                try {
                    item1.id = cursor.getInt(cursor.getColumnIndex("id"))
                    item1.userId = cursor.getInt(cursor.getColumnIndex("userId"))
                    item1.name = cursor.getString(cursor.getColumnIndex("name"))
                    item1.imageId = cursor.getString(cursor.getColumnIndex("imageId"))
                    item1.cupboardId = cursor.getString(cursor.getColumnIndex("cupboardId")).toInt()
                    item1.productionDate = cursor.getString(cursor.getColumnIndex("productionDate"))
                    item1.overdueDate = cursor.getString(cursor.getColumnIndex("overdueDate"))
                    item1.description = cursor.getString(cursor.getColumnIndex("description"))
                    item1.number = cursor.getString(cursor.getColumnIndex("number")).toInt()
                    ItemList.add(item1)
                } catch (e: Exception) {
                    Log.d("error1", "An error occurred: " + e.message) // 最好包括异常的消息
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

//     当 Fragment 变得可见时调用
    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        initItem()
        adapter.notifyDataSetChanged()
    }

    // 从AddActivity中获取新增的Item的id
    @SuppressLint("Range", "Recycle", "NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == AppCompatActivity.RESULT_OK) {
                val NewItemId = data?.getStringExtra("NewItemId")
                val NewItem = Item(EasyStoringApplication.userID.toInt())
                val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
                val db = dbHelper.writableDatabase
                if (NewItemId != null) {
                    val cursor = db.rawQuery("SELECT * FROM Item WHERE id = ?", arrayOf(NewItemId))
                    cursor.moveToFirst()
                    NewItem.id = NewItemId.toInt()
                    NewItem.name = cursor.getString(cursor.getColumnIndex("name"))
                    NewItem.imageId = cursor.getString(cursor.getColumnIndex("imageId"))
                    NewItem.number = cursor.getString(cursor.getColumnIndex("number")).toInt()
                    NewItem.description = cursor.getString(cursor.getColumnIndex("description"))
                    NewItem.productionDate =
                        cursor.getString(cursor.getColumnIndex("productionDate"))
                    NewItem.overdueDate = cursor.getString(cursor.getColumnIndex("overdueDate"))
                    NewItem.cupboardId =
                        cursor.getString(cursor.getColumnIndex("cupboardId")).toInt()
                    ItemList.add(NewItem)
                    // 刷新列表
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}