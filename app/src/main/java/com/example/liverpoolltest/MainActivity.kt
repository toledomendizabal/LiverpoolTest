package com.example.liverpoolltest

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.liverpoolltest.databinding.ActivityMainBinding
import com.example.liverpoolltest.ui.view.ProductsAdapter
import com.example.liverpoolltest.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() , SearchView.OnQueryTextListener{


    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductsAdapter
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter= ProductsAdapter(emptyList())
        binding=ActivityMainBinding.inflate(layoutInflater)
        binding.search.setOnQueryTextListener(this)
        binding.sort.setOnClickListener{
            viewModel.getListSortMin()
        }
        binding.back.setOnClickListener{
            onBackPressed()
        }
        setContentView(binding.root)
        initRecyclerView()
    }
    private fun initRecyclerView(){
        val manager=LinearLayoutManager(this)
        binding.productList.layoutManager=manager
        viewModel.listProducts.observe(this){
            adapter= ProductsAdapter(viewModel.listProducts.value!!)
        }
        binding.productList.adapter=adapter
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        if (p0 != null) {
            viewModel.search= p0.toString()
        }
        viewModel.getList()
        binding.title.text=p0
        return false
    }
}

