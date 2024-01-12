package kh.edu.rupp.ite.cd.model.data

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("image")
     val imageUrl: String?,
)
