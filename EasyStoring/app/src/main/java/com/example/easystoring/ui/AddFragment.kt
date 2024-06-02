package com.example.easystoring.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.easystoring.R

class AddFragment : Fragment() {

    companion object {
        fun newInstance() = AddFragment()
    }

    private lateinit var viewModel: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
//
//        val myButton = view.findViewById<Button>(R.id.button2)
//
//        myButton.setOnClickListener {
//            Toast.makeText(activity, "按钮被点击了", Toast.LENGTH_SHORT).show()
//        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        // TODO: Use the ViewModel
    }

}