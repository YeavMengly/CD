package kh.edu.rupp.ite.cd.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kh.edu.rupp.ite.cd.R
import kh.edu.rupp.ite.cd.databinding.ActivityMainBinding
import kh.edu.rupp.ite.cd.view.fragment.HomeFragment
import kh.edu.rupp.ite.cd.view.fragment.ProductFragment
import kh.edu.rupp.ite.cd.view.fragment.SettingFragment

class MainActivity : AppCompatActivity() {

    // Declare data members
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Call function showFragment
        showFragment( HomeFragment())

        //Handle click btn navigation bar
        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.menuHome -> showFragment(HomeFragment())
                R.id.menuProduct ->showFragment(ProductFragment())
                R.id.menuSetting ->showFragment(SettingFragment())

            }
            true
        }
    }
    private fun showFragment(fragment: Fragment) {4

        //Fragment Transition
        val fragmentTransition = supportFragmentManager.beginTransaction()

        //Replace Fragment Transition
        fragmentTransition.replace(R.id.layoutFragment, fragment)

        //Commit Fragment
        fragmentTransition.commit()
    }
}