package com.example.belajarmvvm.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.belajarmvvm.API.MainRepository
import com.example.belajarmvvm.models.ListPlaceResponseModel

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MainRepository()
    var listPlace: MutableLiveData<ListPlaceResponseModel> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getListPlace(){
        repository.requestListPlace({
            listPlace.postValue(it)
        },{
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }
}