package kh.edu.rupp.ite.cd.view.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kh.edu.rupp.ite.cd.databinding.ActivityLoadingBinding

class ActivityLoading:AppCompatActivity() {
    private lateinit var binding: ActivityLoadingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Handler().postDelayed(Runnable {
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        },2000)
    }
}