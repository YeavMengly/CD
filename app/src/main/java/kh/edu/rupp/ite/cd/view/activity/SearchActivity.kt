package kh.edu.rupp.ite.cd.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.cd.databinding.ActivitySearchBinding

class SearchActivity:AppCompatActivity() {

    // Declare data members
    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Handle click back
        binding.back.setOnClickListener {
            finish()
        }
    }
}