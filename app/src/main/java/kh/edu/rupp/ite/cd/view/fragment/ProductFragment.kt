package kh.edu.rupp.ite.cd.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.adapters.ViewPagerAdapter
import kh.edu.rupp.ite.cd.databinding.FragmentProductBinding
import kh.edu.rupp.ite.cd.model.adapter.ProductAdapter
import kh.edu.rupp.ite.cd.model.data.Product
import kh.edu.rupp.ite.cd.view.ProductView
import kh.edu.rupp.ite.cd.view.activity.ProductDetailActivity
import kh.edu.rupp.ite.cd.viewmodel.ProductViewModel

class ProductFragment : Fragment(){

    // Declare data members
    private lateinit var binding: FragmentProductBinding
    private lateinit var viewModel: ProductViewModel
    private val adapter = ProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(layoutInflater)

        return binding.root
    }

}


