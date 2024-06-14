package com.example.easystoring.ui.UserInformation

//import com.example.easystoring.AppDataBase
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.easystoring.EasyStoringApplication
import com.example.easystoring.R
import com.example.easystoring.databinding.FragmentUserInformationBinding
import com.example.easystoring.ui.AdditemActivity.AddCupboardActivity
import com.example.easystoring.ui.CupboardActivity

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

        binding.browseButton.setOnClickListener {
            startActivity(Intent(EasyStoringApplication.context, CupboardActivity::class.java))
        }

        binding.addButton.setOnClickListener{
            startActivity(Intent(EasyStoringApplication.context,AddCupboardActivity::class.java))
        }

        return binding.root

//        return inflater.inflate(R.layout.fragment_user_information, container, false)
    }
}
