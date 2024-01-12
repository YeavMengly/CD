package kh.edu.rupp.ite.cd.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import com.squareup.picasso.Picasso
import kh.edu.rupp.ite.cd.R
import kh.edu.rupp.ite.cd.databinding.ActivityLoginBinding
import kh.edu.rupp.ite.cd.databinding.ActivityProductDetailBinding
import kh.edu.rupp.ite.cd.databinding.ViewDetailProductBinding

class ProductDetailActivity : AppCompatActivity() {

    // Declare data members
    private lateinit var binding: ViewDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ViewDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val storyArray = intent.getStringArrayExtra("product")

        if (storyArray != null) {
            val storyTitle = storyArray[1]
            val storyImgUrl = storyArray[2]

            binding.txtModels.text = storyTitle.toString()
            Picasso.get().load(storyImgUrl).into(binding.imageUrl)

        } else {
            finish()
        }

        //Handle click back
        binding.back.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

}
