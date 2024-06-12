package com.example.easystoring.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.Item
import com.example.easystoring.ItemAdapter
import com.example.easystoring.R
import com.example.easystoring.databinding.FragmentHomeBinding
import com.example.easystoring.ui.AdditemActivity.AddActivity
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
        initItem()
        val recyclerView : RecyclerView = binding.recyclerView
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager =  layoutManager
        val adapter = ItemAdapter(ItemList)     // 在这里修改物品栏显示的内容
        recyclerView.adapter = adapter

        binding.addButton.setOnClickListener{
            startActivity(Intent(EasyStoringApplication.context, AddActivity::class.java))
        }

        homeViewModel.text.observe(viewLifecycleOwner) {

        }

        return root
    }

    private fun initItem(){
        for(i in 1..10) {
            val item1:Item=Item(1)
            item1.id = i.toLong()
            item1.name = "Item$i"
            item1.imageId = R.drawable.item_pic
            item1.cupboardId = 1
            item1.productionDate = "2024-2-25"
            item1.number = Random.nextInt(10)
            ItemList.add(item1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}