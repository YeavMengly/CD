package kh.edu.rupp.ite.cd.viewmodel

import android.widget.Toast
import kh.edu.rupp.ite.cd.model.data.Product
import kh.edu.rupp.ite.cd.model.service.ApiServiceProduct
import kh.edu.rupp.ite.cd.view.ProductView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Objects
class ProductViewModel(private val productView: ProductView) {

    // create fun loadProduct
    fun loadProduct() {

        // create retrofit client
        val httpClient = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // create service object
        val apiService = httpClient.create(ApiServiceProduct::class.java)

        // load product from serve
        val task = apiService.loadProductList()
        task.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                // check condition
                if (response.isSuccessful) {
                    response.body()?.let { productList ->
                        productView.showProductList(productList)
                    }
                } else {
                    productView.showError("Error loading data from server")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                productView.showError("Error loading data from server")
            }
        })
    }
}
