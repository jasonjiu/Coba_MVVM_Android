package com.example.belajarmvvm.API

import com.example.belajarmvvm.models.ListPlaceResponseModel
import io.reactivex.Observable
import retrofit2.http.GET

interface RestAPI {
    @GET("Sample.json")
    fun getListPlace(): Observable<ListPlaceResponseModel>
}