package kh.edu.rupp.ite.cd.model.adapter

import android.graphics.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kh.edu.rupp.ite.cd.databinding.ViewHolderProductBinding
import kh.edu.rupp.ite.cd.model.data.Product


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // Declare data members
    private var productList: List<Product> = ArrayList()
    private var onProductClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(product:Product?, position: Int)
    }

    fun setOnProductClickListener(listener:OnItemClickListener) {
        onProductClickListener = listener
    }

    fun submitList(products: List<Product>) {
        productList = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ViewHolderProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var product = productList.get(position)
        holder.bind(product)


        holder.itemView.setOnClickListener{
            var adapterPosition = holder.adapterPosition
            onProductClickListener?.onItemClick(product,adapterPosition)
        }
    }

    override fun getItemCount(): Int {
        return productList.size

    }

    inner class ProductViewHolder(private val binding: ViewHolderProductBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {

            // Bind data to the view elements in the item layout
            binding.txtName.text = product.title
            Picasso.get().load(product.imageUrl).into(binding.imageUrl)
        }
    }

}

