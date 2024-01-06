package kh.edu.rupp.ite.cd.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.AnimationTypes
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import kh.edu.rupp.ite.cd.R
import kh.edu.rupp.ite.cd.databinding.ActivityMainBinding
import kh.edu.rupp.ite.cd.view.fragment.HomeFragment
import kh.edu.rupp.ite.cd.view.fragment.ProductFragment
import kh.edu.rupp.ite.cd.view.fragment.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        showFragment( HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.menuHome -> showFragment(HomeFragment())
                R.id.menuProduct ->showFragment(ProductFragment())
                R.id.menuSetting ->showFragment(SettingFragment())

            }
            true

        }
    }
    private fun showFragment(fragment: Fragment) {

        //Fragment Transition
        val fragmentTransition = supportFragmentManager.beginTransaction()

        //Replace Fragment Transition
        fragmentTransition.replace(R.id.layoutFragment, fragment)

        //Commit Fragment
        fragmentTransition.commit()
    }
}