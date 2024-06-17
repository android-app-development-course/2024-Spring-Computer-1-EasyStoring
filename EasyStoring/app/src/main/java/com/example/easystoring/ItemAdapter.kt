package com.example.easystoring

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.logic.model.AppDBHelper
import com.example.easystoring.ui.ItemActivity
import kotlin.Exception

class ItemAdapter(private val context: Context, val itemList:MutableList<Item>) :
    // 这个函数修改显示的内容
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val ItemImage: ImageView = view.findViewById(R.id.itemImage)
        val ItemName: TextView = view.findViewById(R.id.itemName)
        val belongTo: TextView = view.findViewById(R.id.item_belongTo)
        val productionDate: TextView = view.findViewById(R.id.item_productionDate)
        val ItemNum: TextView = view.findViewById(R.id.item_num)
        val del:Button = view.findViewById(R.id.button7)
    }
    // 收纳柜字典
    var cupboardNameMap  = mutableMapOf<Int, String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_item, parent, false)
        val viewHolder = ViewHolder(view)

        val dbHelper = AppDBHelper(viewHolder.itemView.context, "EasyStoring.db", 1)
        val db = dbHelper.writableDatabase
        val cupboards = dbHelper.getAllRowsFromMyTable(db,"Cupboard")
        try {
            if (cupboards.isNotEmpty()) {
                for (i in 0..<cupboards.count()) {
                    cupboardNameMap[cupboards[i]["id"].toString().toInt()] =
                        cupboards[i]["name"].toString()
                }
            }
        }catch (e:Exception){
            Log.d("error2",e.message!!)
        }

        // 点击整个事件
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            val item = itemList[position]
            // 点击事件后，跳转界面，传信息
            try {
                val intent = Intent(viewHolder.itemView.context, ItemActivity::class.java).apply {
                    putExtra("position", position.toString())
                    putExtra("itemId",item.id.toString())
                }
                viewHolder.itemView.context.startActivity(intent)
            }
            catch (e:Exception){
                Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
            }
        }
        // 点击图片
        viewHolder.ItemImage.setOnClickListener {

        }

        viewHolder.del.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                // 通知Adapter删除该项
                this.removeItem(position)
            }
        }
        return viewHolder
    }

    // 填入信息
    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.ItemName.text = item.name
        holder.ItemName.typeface = Typeface.DEFAULT_BOLD
        holder.productionDate.text = item.productionDate
        if (cupboardNameMap.containsKey(item.cupboardId))
            holder.belongTo.text = cupboardNameMap[item.cupboardId]
        else{
            holder.belongTo.text ="默认收纳柜"
            itemList[position].cupboardId = -1
        }
        holder.ItemNum.text = "×${item.number}"
    }

    override fun getItemCount()=itemList.size
    @SuppressLint("NotifyDataSetChanged")
    fun removeItem(position: Int) {
        // 检查位置是否有效
        if (position in 0 until itemCount) {
            // 从列表中移除项并从数据库中删除
            val delItem = itemList.removeAt(position)
            val ItemId = delItem.id
            val dbHelper = AppDBHelper(context, "EasyStoring.db", 1)
            val db = dbHelper.writableDatabase
            dbHelper.delItemById(db, ItemId)
            dbHelper.DeviceToSever(db)
            // 通知RecyclerView项已被移除
            notifyItemRemoved(position)

            // 如果列表为空，可能还需要通知数据集变化
            if (itemList.isEmpty()) {
                notifyDataSetChanged()
            }
        }
    }
}