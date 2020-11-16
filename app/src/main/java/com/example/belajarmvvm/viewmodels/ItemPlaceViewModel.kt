package com.example.belajarmvvm.viewmodels

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.belajarmvvm.models.ListPlaceResponseModel

class ItemPlaceViewModel (model: ListPlaceResponseModel.PlaceModel) : ViewModel() {
    var title: ObservableField<String> = ObservableField()
    var location: ObservableField<String> = ObservableField()
    var image: ObservableField<String> = ObservableField()

    init {
        title.set(model.name)
        location.set(model.location)
        image.set(model.image)
    }
}