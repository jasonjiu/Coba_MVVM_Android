package com.example.belajarmvvm

import com.example.belajarmvvm.API.APIObserver
import com.example.belajarmvvm.API.ServiceFactory
import com.example.belajarmvvm.models.listPlaceResponseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainRepository {
    private val apiService = ServiceFactory.create()
    private val compositeDisposable = CompositeDisposable()

    fun requestListPlace(onResult: (listPlaceResponseModel) -> Unit, onError: (Throwable) -> Unit){
        apiService.getListPlace()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : APIObserver<listPlaceResponseModel>(compositeDisposable){
                override fun onApiSuccess(data: listPlaceResponseModel) {
                    onResult(data)
                }

                override fun onApiError(er: Throwable) {
                    onError(er)
                }
            })
    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}