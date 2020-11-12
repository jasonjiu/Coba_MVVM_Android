package com.example.belajarmvvm.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.belajarmvvm.R
import com.example.belajarmvvm.databinding.ActivityMainBinding
import com.example.belajarmvvm.models.Mahasiswa
import com.example.belajarmvvm.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.main = viewModel

        val mhs = Mahasiswa("1901465525", "Jason anggarah", "Computer Science")
        viewModel.setData(mhs)
    }
}