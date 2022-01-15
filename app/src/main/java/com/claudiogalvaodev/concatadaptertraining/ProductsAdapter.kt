package com.claudiogalvaodev.concatadaptertraining

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.claudiogalvaodev.concatadaptertraining.ProductsAdapter.*
import com.claudiogalvaodev.concatadaptertraining.databinding.ItemProductBinding

class ProductsAdapter: ListAdapter<Product, ProductsViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((product: Product) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder.create(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }
        }
    }

    class ProductsViewHolder(
        private val binding: ItemProductBinding,
        private val clickListener: ((product: Product) -> Unit)?
        ): RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.apply {
                itemProductTitle.text = product.name
                itemProductDesc.text = product.description
                itemProductPrice.text = product.price
                itemProductImage.setImageResource(product.image)

                root.setOnClickListener {
                    clickListener?.invoke(product)
                }
            }
        }

        companion object {
            fun create(parent: ViewGroup, clickListener: ((product: Product) -> Unit)?): ProductsViewHolder {
                val binding = ItemProductBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return ProductsViewHolder(binding, clickListener)
            }
        }
    }

}