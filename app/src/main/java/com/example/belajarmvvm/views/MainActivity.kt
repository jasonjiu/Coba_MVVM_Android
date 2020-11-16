package com.example.belajarmvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarmvvm.R
import com.example.belajarmvvm.adapter.ListPlaceAdapter
import com.example.belajarmvvm.databinding.ActivityMainBinding
import com.example.belajarmvvm.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ListPlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setUpRecyclerView()
        observeLiveData()

       viewModel.getListPlace()
    }

    private fun setUpRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPlace.layoutManager = layoutManager
        adapter = ListPlaceAdapter(this)
        binding.recyclerViewPlace.adapter = adapter
    }

    private fun observeLiveData(){
        viewModel.listPlace.observe(this, Observer {
            adapter.setData(it?.data!!)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {
            Log.e("view_model_err", "error view model" )
        })
    }
}