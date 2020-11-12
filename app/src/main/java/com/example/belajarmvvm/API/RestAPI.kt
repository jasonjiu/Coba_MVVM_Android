package com.example.belajarmvvm.API

import com.example.belajarmvvm.models.listPlaceResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestAPI {
    @GET("Sample.json")
    fun getListPlace(): Observable<listPlaceResponseModel>
}