package com.example.easystoring.ui.CupboardFragment

//import com.example.easystoring.AppDataBase
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.Cupboard
import com.example.easystoring.CupboardAdapter
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.databinding.FragmentCupboardBinding
import com.example.easystoring.logic.model.AppDBHelper
import com.example.easystoring.ui.AdditemActivity.AddCupboardActivity

class CupboardFragment : Fragment() {

    private var _binding: FragmentCupboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val CupboardList = ArrayList<Cupboard>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CupboardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCupboardBinding.inflate(inflater,container,false)
        val root: View = binding.root

        initCupboard()
        recyclerView = binding.recyclerView
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        adapter = CupboardAdapter(requireContext(), CupboardList)     // 在这里修改物品栏显示的内容
        recyclerView.adapter = adapter

        binding.addCupboard.setOnClickListener {
            startActivityForResult(Intent(EasyStoringApplication.context,
                AddCupboardActivity::class.java),1)
        }
        return root
    }

    @SuppressLint("Range")
    private fun initCupboard() {
        CupboardList.clear()
        val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM Cupboard WHERE userId = ?", arrayOf(
            EasyStoringApplication.userID))

        var CupboardNum = 0
        // 遍历查询结果
        if (cursor.moveToFirst()) {
            do {
                CupboardNum++
                val Cupboard1: Cupboard = Cupboard(EasyStoringApplication.userID.toInt())
                try {
                    Cupboard1.id = cursor.getInt(cursor.getColumnIndex("id"))
                    Cupboard1.userId = cursor.getInt(cursor.getColumnIndex("userId"))
                    Cupboard1.name = cursor.getString(cursor.getColumnIndex("name"))
                    Cupboard1.description = cursor.getString(cursor.getColumnIndex("description"))
                    CupboardList.add(Cupboard1)
                } catch (e: Exception) {
                    Log.d("error2", "An error occurred: " + e.message) // 最好包括异常的消息
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
        initCupboard()
        adapter.notifyDataSetChanged()
    }

    // 从AddActivity中获取新增的Item的id
    @SuppressLint("Range", "Recycle", "NotifyDataSetChanged")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == AppCompatActivity.RESULT_OK) {
                val NewCupboardId = data?.getStringExtra("NewCupboardId")
                val NewCupboard = Cupboard(EasyStoringApplication.userID.toInt())
                val dbHelper = AppDBHelper(requireContext(), "EasyStoring.db", 1)
                val db = dbHelper.writableDatabase
                if (NewCupboardId != null) {
                    val cursor = db.rawQuery("SELECT * FROM Cupboard WHERE id = ?", arrayOf(NewCupboardId))
                    cursor.moveToFirst()
                    NewCupboard.id = NewCupboardId.toInt()
                    NewCupboard.name = cursor.getString(cursor.getColumnIndex("name"))
                    NewCupboard.description = cursor.getString(cursor.getColumnIndex("description"))
                    CupboardList.add(NewCupboard)
                    // 刷新列表
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}
