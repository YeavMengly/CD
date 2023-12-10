package kh.edu.rupp.ite.cd.view.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
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

class ImageSliderActivity:AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.fragment_home)
        super.onCreate(savedInstanceState)
        val imageSlider = findViewById<ImageSlider>(R.id.image_slider) // init imageSlider

        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel("https://wheninphnompenh.com/wp-content/uploads/2023/05/DSC_0078-1024x1024.jpg", "The future is our hands.",))
        imageList.add(SlideModel("https://wheninphnompenh.com/wp-content/uploads/2023/05/DSC_0078-1024x1024.jpg", "Climate change is moving very fast."))
        imageList.add(SlideModel("https://wheninphnompenh.com/wp-content/uploads/2023/05/DSC_0078-1024x1024.jpg", "The population has decreased by 27 percent in the last 5 years."))

        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)

        imageSlider.setSlideAnimation(AnimationTypes.ZOOM_OUT)

        imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
                // You can listen here.
                println("normal")
            }

            override fun doubleClick(position: Int) {
                // Do not use onItemSelected if you are using a double click listener at the same time.
                // Its just added for specific cases.
                // Listen for clicks under 250 milliseconds.
                println("its double")
            }
        })

        imageSlider.setItemChangeListener(object : ItemChangeListener {
            override fun onItemChanged(position: Int) {
                //println("Pos: " + position)
            }
        })

        imageSlider.setTouchListener(object : TouchListener {
            override fun onTouched(touched: ActionTypes, position: Int) {
                if (touched == ActionTypes.DOWN){
                    imageSlider.stopSliding()
                } else if (touched == ActionTypes.UP ) {
                    imageSlider.startSliding(1000)
                }
            }
        })
    }


}