package com.example.easystoring.ui.AdditemActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.easystoring.R

class AddPicFragment : Fragment() {

    companion object {
        fun newInstance() = AddPicFragment()
    }

    private lateinit var viewModel: AddPicViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_pic, container, false)

        // Find the button and set the click listener
        view.findViewById<Button>(R.id.button_in_fragment).setOnClickListener {
            Toast.makeText(context, "Button clicked in Fragment!", Toast.LENGTH_SHORT).show()
        }


        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddPicViewModel::class.java)
        // TODO: Use the ViewModel
    }


}