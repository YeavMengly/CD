package kh.edu.rupp.ite.cd.view.fragment

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ActionTypes
import com.denzcoskun.imageslider.constants.AnimationTypes
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemChangeListener
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.interfaces.TouchListener
import com.denzcoskun.imageslider.models.SlideModel
import kh.edu.rupp.ite.cd.R
import kh.edu.rupp.ite.cd.databinding.ActivityMainBinding
import kh.edu.rupp.ite.cd.databinding.FragmentHomeBinding
import kh.edu.rupp.ite.cd.view.activity.ImageSliderActivity
import kh.edu.rupp.ite.cd.view.activity.SearchActivity

class HomeFragment:Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel("https://img.freepik.com/free-psd/black-friday-big-sale-social-media-banner-design-template_47987-17223.jpg",))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7dSwWs4nUIpbnQ9y7g6kDzSrliCcF08OWNg&usqp=CAU",))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcKQ4wJKwDtzw_nqOlxrIj6fgiHxv6o4c3UfBFDzrjfbuU_MH4uD3r9q_dnOFrLeiqrgk&usqp=CAU", ))
        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider) // init imageSlider
        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)

        //Click to fragmentSearch
        binding?.searchBar?.setOnClickListener{
            startActivity(Intent(context, SearchActivity::class.java))
        }
    }




}