package kh.edu.rupp.ite.cd.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.cd.databinding.ViewDetailProductBinding

class ViewProductActivity:AppCompatActivity() {

    // Declare data members
    private lateinit var binding: ViewDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ViewDetailProductBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.back.setOnClickListener(){
        }
    }
}