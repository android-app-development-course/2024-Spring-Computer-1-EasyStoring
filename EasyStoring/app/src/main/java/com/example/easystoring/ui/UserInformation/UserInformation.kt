package com.example.easystoring.ui.UserInformation

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

//        val insertButton = view.findViewById<Button>(R.id.insertButton)
        val insertButton = binding.insertButton
        val updateButton = binding.updateButton
        val queryAllButton = binding.queryAllButton

//        val userDao = AppDataBase.getDatabase(EasyStoringApplication.context).userDao()
//        val user1 = User("Anon", "111")
//        val user2 = User("Soyo", "222")
        insertButton.setOnClickListener {
            thread {

                val client = OkHttpClient()
                val request =
                    Request.Builder().url("http://1.15.173.30:8997/getUsername").build()

                val response = client.newCall(request).execute()
                val result = response.body()?.string()

//                val type= object :TypeToken<List<App>>(){}.type
                var usernames = Gson().fromJson(result, App::class.java)
                usernames?.let {
                    Log.d("2333", it.id)
                    Log.d("2333", it.name)
                    Log.d("2333", it.version)

                }
            }

//            thread {
//                user1.id = userDao.insertUser(user1)
//                user2.id = userDao.insertUser(user2)
//            }
//            Toast.makeText(EasyStoringApplication.context,"2333",Toast.LENGTH_SHORT).show()
//            val retrofit = Retrofit.Builder().baseUrl("http://1.15.173.30:8997")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//            val appService = retrofit.create(AppService::class.java)
//            appService.getAppData().enqueue(object : Callback<List<App>> {
//                override fun onResponse(call: Call<List<App>>, response: Response<List<App>>) {
//                    val list = response.body()
//                    Log.d("2333",response.message())
//                    if (list != null) {
////                        var text = ""
////                        for (app in list)
////                        {
////                            Log.d("2333Logging!",app.name)
////                            Log.d("2333Logging!",app.id)
////                            Log.d("2333Logging!",app.version)
////                        }
//                        Log.d("2333",list.toString())
//                        Log.d("2333Logging!","Not Null")
//                    }
//                    Log.d("2333Logging!","Finish")
//                }
//
//                override fun onFailure(call: Call<List<App>>, t: Throwable) {
////                    binding.textView.
//                    //                    text = t.stackTrace.toString()
//                    t.printStackTrace()
//
//                    Log.d("2333Logging!","Error")
//                    Log.d("2333Logging!",t.message.toString())
//                }
//            })
//            val appService=ServiceCreator.create<AppService>()
//            appService.getUsername().enqueue(object :Callback<List<Username>>{
//                override fun onResponse(
//                    call: Call<List<Username>>,
//                    response: Response<List<Username>>
//                ) {
//                    val res=response.raw()
//                    Log.d("2333", res.message())
//                }
//
//                override fun onFailure(call: Call<List<Username>>, t: Throwable) {
//                    Log.d("2333",t.message.toString())
//                }
//            })
        }
        return binding.root

//        return inflater.inflate(R.layout.fragment_user_information, container, false)
    }
}
