package com.example.easystoring.ui.UserInformation

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.room.util.recursiveFetchLongSparseArray
//import com.example.easystoring.AppDataBase
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.MainActivity
import com.example.easystoring.R
import com.example.easystoring.User
import com.example.easystoring.databinding.FragmentDashboardBinding
import com.example.easystoring.databinding.FragmentUserInformationBinding
import com.example.easystoring.logic.network.App
import com.example.easystoring.logic.network.AppService
import com.example.easystoring.logic.network.ServiceCreator
import com.example.easystoring.logic.network.Username
import com.example.easystoring.ui.AdditemActivity.AddCupboardActivity
import com.example.easystoring.ui.CupboardActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.concurrent.thread

class UserInformation : Fragment() {

    private var _binding: UserInformation? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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

        val binding = FragmentUserInformationBinding.inflate(layoutInflater)


        binding.createButton.setOnClickListener {
            startActivity(Intent(EasyStoringApplication.context,AddCupboardActivity::class.java))
        }

        binding.browseButton.setOnClickListener {
            startActivity(Intent(EasyStoringApplication.context, CupboardActivity::class.java))
        }

        return binding.root

//        return inflater.inflate(R.layout.fragment_user_information, container, false)
    }
}
