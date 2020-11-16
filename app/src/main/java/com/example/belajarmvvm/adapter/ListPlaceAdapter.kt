package com.example.belajarmvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarmvvm.R
import com.example.belajarmvvm.databinding.ItemPlaceBinding
import com.example.belajarmvvm.models.ListPlaceResponseModel
import com.example.belajarmvvm.viewmodels.ItemPlaceViewModel

class ListPlaceAdapter (val context: Context) :
    RecyclerView.Adapter<ListPlaceAdapter.ItemPlaceHolder>() {

    private var listPlace: MutableList<ListPlaceResponseModel.PlaceModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPlaceAdapter.ItemPlaceHolder {
        val binding: ItemPlaceBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_place, parent, false)
        return ItemPlaceHolder(binding)
    }

    override fun onBindViewHolder(holder: ListPlaceAdapter.ItemPlaceHolder, position: Int) {
        holder.bindData(listPlace[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return listPlace.size
    }

    fun setData(list: MutableList<ListPlaceResponseModel.PlaceModel>){
        this.listPlace = list
    }

    class ItemPlaceHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(model: ListPlaceResponseModel.PlaceModel){
            val viewModel = ItemPlaceViewModel(model)
            binding.itemPlace = viewModel
        }
    }
}