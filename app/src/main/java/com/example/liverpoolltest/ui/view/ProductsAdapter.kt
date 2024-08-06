package com.example.liverpoolltest.ui.view

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.liverpoolltest.R
import com.example.liverpoolltest.data.models.Records
import com.example.liverpoolltest.databinding.ProductItemBinding

class ProductsAdapter(val records: List<Records>): RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context)
        return ProductsViewHolder(view.inflate(R.layout.product_item,parent,false))
    }

    override fun getItemCount(): Int {
        return records.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(records[position])
    }
    class ProductsViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val binding = ProductItemBinding.bind(view)

        fun bind(records : Records) {
            Glide.with(binding.productImage)
                .load(records.smImage)
                .into(binding.productImage)
            binding.nameProduct.text=records.productDisplayName
            binding.price.text="$"+records.listPrice.toString()
            binding.priceDesc.text="$"+records.promoPrice.toString()

        }
    }
}