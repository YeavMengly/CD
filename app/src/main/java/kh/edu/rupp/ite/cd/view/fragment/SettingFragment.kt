package kh.edu.rupp.ite.cd.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kh.edu.rupp.ite.cd.databinding.FragmentHomeBinding
import kh.edu.rupp.ite.cd.databinding.FragmentSettingBinding
import kh.edu.rupp.ite.cd.view.activity.ActivityLoading
import kh.edu.rupp.ite.cd.view.activity.LoginActivity

class SettingFragment: Fragment() {

    // Declare data members
    private lateinit var binding: FragmentSettingBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentSettingBinding.inflate(layoutInflater)

        val logoutGo: RelativeLayout = binding.logout

        // Initialize Firebase Authentication
        auth = FirebaseAuth.getInstance()

        // Handle click logOut
        logoutGo.setOnClickListener {
            // Call function logOutUser
            logOutUser()
        }
        return binding.root
    }
    private fun logOutUser(){

        auth.signOut()

        // Create intent
        val intent = Intent(context, ActivityLoading::class.java)
        startActivity(intent)
        requireActivity().finish()
    }
}