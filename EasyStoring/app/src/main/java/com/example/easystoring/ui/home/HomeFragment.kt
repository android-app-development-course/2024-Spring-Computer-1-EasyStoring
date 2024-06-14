package com.example.easystoring.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.Item
import com.example.easystoring.ItemAdapter
import com.example.easystoring.R
import com.example.easystoring.databinding.FragmentHomeBinding
import com.example.easystoring.logic.model.AppDBHelper
import com.example.easystoring.logic.model.DBShow
import java.lang.Exception
import kotlin.random.Random


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
        val recyclerView : RecyclerView = binding.recyclerView
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager =  layoutManager
        val adapter = ItemAdapter(ItemList)     // 在这里修改物品栏显示的内容
        recyclerView.adapter = adapter




        homeViewModel.text.observe(viewLifecycleOwner) {

        }

        return root
    }

    // 从数据库中读取物品信息
    @SuppressLint("Range")
    private fun initItem(){
        val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM Item WHERE userId = ?", arrayOf("1"))

        var ItemNum = 0
        // 遍历查询结果
        if (cursor.moveToFirst()) {
            do {
                ItemNum++
                val item1:Item=Item(1)
                item1.id = ItemNum
                try {
                    item1.userId = cursor.getInt(cursor.getColumnIndex("userId"))
                    item1.name = cursor.getString(cursor.getColumnIndex("name"))
                    item1.imageId = cursor.getString(cursor.getColumnIndex("imageId"))
                    item1.cupboardId = cursor.getString(cursor.getColumnIndex("cupboardId")).toInt()
                    item1.productionDate = cursor.getString(cursor.getColumnIndex("productionDate"))
                    item1.number = cursor.getString(cursor.getColumnIndex("number")).toInt()
                    ItemList.add(item1)
                }catch (e:Exception)
                {
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