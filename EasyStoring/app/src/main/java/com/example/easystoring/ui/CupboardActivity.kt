package com.example.easystoring.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.Item
import com.example.easystoring.ItemAdapter
import com.example.easystoring.R
import com.example.easystoring.databinding.FragmentHomeBinding
import com.example.easystoring.ui.home.HomeViewModel
import kotlin.random.Random

class CupboardActivity : AppCompatActivity() {
    private val ItemList = ArrayList<Item>()
    private val StoryingList = ArrayList<Storying>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_cupboard)
//        initItem()
        initStoryings()
        val toolbar:Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        initItem()
        val recyclerView : RecyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        val adapter = StoryingAdapter(StoryingList)
//        val adapter = ItemAdapter(ItemList)     // 在这里修改物品栏显示的内容
        recyclerView.adapter = adapter

        val button2: Button =findViewById(R.id.button2)
        button2.setOnClickListener {
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initStoryings(){
        repeat(2){
            StoryingList.add(Storying("书架"))
            StoryingList.add(Storying("玩具"))
        }
    }

    private fun initItem(){
        for(i in 1..10) {
            val item1: Item = Item(1)
            item1.id = i
            item1.name = "Item$i"
//            item1.imageId = R.drawable.item_pic
            item1.cupboardId = Random.nextInt(2)
            item1.productionDate = "2024-2-25"
            item1.number = Random.nextInt(10)
            ItemList.add(item1)
        }
    }
}

class Storying(val name:String)

class StoryingAdapter(val StoryingList:List<Storying>):
        RecyclerView.Adapter<StoryingAdapter.ViewHolder>(){

   inner class ViewHolder(view:View):RecyclerView.ViewHolder(view){
       val storyingName:TextView = view.findViewById(R.id.storyingName)
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.storying__item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val storying = StoryingList[position]
        holder.storyingName.text = storying.name
    }

    override fun getItemCount(): Int {
        return StoryingList.size
    }

}


