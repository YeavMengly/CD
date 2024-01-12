package kh.edu.rupp.ite.cd.view.fragment

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import kh.edu.rupp.ite.cd.R
import kh.edu.rupp.ite.cd.databinding.FragmentHomeBinding
import kh.edu.rupp.ite.cd.model.adapter.ProductAdapter
import kh.edu.rupp.ite.cd.model.data.Product
import kh.edu.rupp.ite.cd.view.ProductView
import kh.edu.rupp.ite.cd.view.activity.ProductDetailActivity
import kh.edu.rupp.ite.cd.view.activity.SearchActivity
import kh.edu.rupp.ite.cd.viewmodel.ProductViewModel

class HomeFragment : Fragment(), ProductView ,ProductAdapter.OnItemClickListener{

    // Declare data members
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: ProductViewModel
    private val adapter = ProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("https://img.freepik.com/free-psd/black-friday-big-sale-social-media-banner-design-template_47987-17223.jpg"))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7dSwWs4nUIpbnQ9y7g6kDzSrliCcF08OWNg&usqp=CAU"))
        imageList.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcKQ4wJKwDtzw_nqOlxrIj6fgiHxv6o4c3UfBFDzrjfbuU_MH4uD3r9q_dnOFrLeiqrgk&usqp=CAU"))
        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList, ScaleTypes.CENTER_CROP)

        // Click to fragmentSearch
        binding.searchBar.setOnClickListener {
            startActivity(Intent(context, SearchActivity::class.java))
        }

        viewModel = ProductViewModel(this) // Pass the reference to this fragment as ProductView
        viewModel.loadProduct()

        // Create layout manager with horizontal orientation
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        // Setup RecyclerView
        binding.recycleView.layoutManager = layoutManager
        binding.recycleView.adapter = adapter
        adapter.setOnProductClickListener(this)
    }
    override fun showProductList(product: List<Product>) {
        //check condition
        if (product.isEmpty()) {
            Toast.makeText(context, "No products data", Toast.LENGTH_LONG).show()
        } else {
            adapter.submitList(product)
        }
    }
    override fun showProductDetail(product: Product) {

    }
    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    override fun onItemClick(product: Product?, position: Int) {
        Toast.makeText(context, product?.title, Toast.LENGTH_LONG).show()
        val array = arrayOf(
            product?.id.toString(),
            product?.title,
            product?.imageUrl
        )
        //into display productDetail
        val intent = Intent(context, ProductDetailActivity::class.java)
        intent.putExtra("product", array)
        startActivity(intent)
    }
}
