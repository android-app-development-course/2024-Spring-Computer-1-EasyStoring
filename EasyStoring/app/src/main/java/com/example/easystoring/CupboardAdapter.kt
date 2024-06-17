package com.example.easystoring

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
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.logic.model.AppDBHelper
import com.example.easystoring.ui.CupboardActivity
import com.example.easystoring.ui.ItemActivity
import java.lang.Exception

class CupboardAdapter(private val context: Context, val cupboardList:MutableList<Cupboard>) :
    RecyclerView.Adapter<CupboardAdapter.ViewHolder>(){
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val CupboardImage: ImageView = view.findViewById(R.id.cupboardImage)
        val Cupboardname:TextView = view.findViewById(R.id.cupboardName)
        val del:Button = view.findViewById(R.id.button_del)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.storying__item, parent, false)
        val viewHolder = ViewHolder(view)

        // 点击整个事件
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            val cupboard = cupboardList[position]
            // 点击事件后，跳转界面，传信息
            try {
                val intent = Intent(viewHolder.itemView.context, CupboardActivity::class.java).apply {
                    putExtra("position", position.toString())
                    putExtra("cupboardId",cupboard.id.toString())
                    putExtra("cupboardName",cupboard.name)
                }
                viewHolder.itemView.context.startActivity(intent)
            }
            catch (e:Exception){
                Log.d("error", "An error occurred: " + e.message) // 最好包括异常的消息
            }
        }
        viewHolder.del.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                // 通知Adapter删除该项
                this.removeItem(position)
            }
        }

        return  viewHolder
    }

    override fun getItemCount()=cupboardList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cupboard = cupboardList[position]

        holder.Cupboardname.text = cupboard.name
        holder.Cupboardname.typeface = Typeface.DEFAULT_BOLD

//        if (cupboardMap.containsKey(item.cupboardId))
//            holder.belongTo.text = cupboardMap[item.cupboardId]?.name ?:""
//        holder.ItemNum.text = "×${item.number}"
    }

    fun removeItem(position: Int) {
        // 检查位置是否有效
        if (position in 0 until itemCount) {
            // 从列表中移除项并从数据库中删除
            val delCupboard = cupboardList.removeAt(position)
            val cupboardId = delCupboard.id
            val dbHelper = AppDBHelper(context, "EasyStoring.db", 1)
            val db = dbHelper.writableDatabase
            dbHelper.delCupboardById(db, cupboardId)
            dbHelper.DeviceToSever(db)
            // 通知RecyclerView项已被移除
            notifyItemRemoved(position)

            // 如果列表为空，可能还需要通知数据集变化
            if (cupboardList.isEmpty()) {
                notifyDataSetChanged()
            }
        }
    }
}