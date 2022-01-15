package com.claudiogalvaodev.concatadaptertraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ConcatAdapter
import com.claudiogalvaodev.concatadaptertraining.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val announcementsAdapter = AnnouncementsAdapter()
        val productsAdapter = ProductsAdapter().apply {
            onItemClick = { product ->
                showMessage(message = product.name)
            }
        }

        binding.activityMainRecyclerview.adapter = ConcatAdapter(announcementsAdapter, productsAdapter)

        announcementsAdapter.submitList(announcements.sortedBy { ads -> ads.order })
        productsAdapter.submitList(products)
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, "$message was clicked", Toast.LENGTH_LONG).show()
    }
}