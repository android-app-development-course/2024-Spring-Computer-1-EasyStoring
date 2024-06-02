package com.example.easystoring

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.ui.ItemActivity

class ItemAdapter(val itemList:List<Item>) :
    // 这个函数修改显示的内容
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val ItemImage: ImageView = view.findViewById(R.id.itemImage)
        val ItemName: TextView = view.findViewById(R.id.itemName)
        val belongTo: TextView = view.findViewById(R.id.item_belongTo)
        val productionDate: TextView = view.findViewById(R.id.item_productionDate)
        val ItemNum: TextView = view.findViewById(R.id.item_num)

//        var ItemBelongTo:
    }
    // 用户字典
    var userMap  = mutableMapOf<Int, User>()
    // 收纳柜字典
    var cupboardMap  = mutableMapOf<Int, Cupboard>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_item, parent, false)
        val viewHolder = ViewHolder(view)

        // 计划从room中读取数据
        // 现暂时用一个来测试
        val user1: User = User("user1","12345")
        user1.id = 1
        userMap[user1.id] = user1
        val cupboard1 :Cupboard = Cupboard(user1.id)
        cupboard1.id = 1
        cupboard1.name = "书架1"
        val cupboard2 :Cupboard = Cupboard(user1.id)
        cupboard2.id = 0
        cupboard2.name = "书架2"
        cupboardMap[cupboard1.id]=cupboard1
        cupboardMap[cupboard2.id]=cupboard2

        // 点击整个事件
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            val item = itemList[position]
            // 点击事件后，跳转界面，传信息
            val intent = Intent(viewHolder.itemView.context, ItemActivity::class.java).apply {
                putExtra("position", position.toString())
            }
            viewHolder.itemView.context.startActivity(intent)
            Toast.makeText(parent.context, "clicked view ${item.name}",
                Toast.LENGTH_SHORT).show()
        }
        // 点击图片
        viewHolder.ItemImage.setOnClickListener {

        }
        return viewHolder
    }

    // 填入信息
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.ItemImage.setImageResource(item.imageId)
        holder.ItemName.text = item.name
        holder.ItemName.typeface = Typeface.DEFAULT_BOLD
        holder.productionDate.text = item.productionDate
        if (cupboardMap.containsKey(item.cupboardId))
            holder.belongTo.text = cupboardMap[item.cupboardId]?.name ?:""
        holder.ItemNum.text = "×${item.number}"
    }

    override fun getItemCount()=itemList.size
}