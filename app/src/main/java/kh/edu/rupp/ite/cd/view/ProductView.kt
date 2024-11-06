package kh.edu.rupp.ite.cd.view

import kh.edu.rupp.ite.cd.model.data.Product

interface ProductView {

    //show product list
    fun showProductList(product: List<Product>)

    //show product detail
    fun showProductDetail(product: Product)

    //show error
    fun showError (message: String)
}