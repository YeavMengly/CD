package kh.edu.rupp.ite.cd.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.cd.databinding.FragmentHomeBinding
import kh.edu.rupp.ite.cd.databinding.FragmentSettingBinding

class SettingFragment: Fragment() {

    private lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentSettingBinding.inflate(layoutInflater)
        return binding.root
    }
}