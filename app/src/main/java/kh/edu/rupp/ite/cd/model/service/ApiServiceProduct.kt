package kh.edu.rupp.ite.cd.model.service

import kh.edu.rupp.ite.cd.model.data.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiServiceProduct {

    @GET("/products")
    fun loadProductList(): Call<List<Product>>

}