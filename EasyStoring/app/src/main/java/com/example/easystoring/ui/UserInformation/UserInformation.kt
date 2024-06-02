package com.example.easystoring.ui.UserInformation

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.MainActivity
import com.example.easystoring.R

class UserInformation : Fragment() {

    companion object {
        fun newInstance() = UserInformation()
    }

    private val viewModel: UserInformationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_user_information, container, false)
        val insertB=view.findViewById<Button>(R.id.insertButton)
        insertB.setOnClickListener {
            Toast.makeText(EasyStoringApplication.context,"2333",Toast.LENGTH_SHORT).show()
        }
        return view

//        return inflater.inflate(R.layout.fragment_user_information, container, false)
    }
}