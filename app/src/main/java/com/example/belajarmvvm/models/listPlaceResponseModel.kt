package com.example.belajarmvvm.models

import android.telephony.cdma.CdmaCellLocation
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class listPlaceResponseModel (
    @SerializedName("status_code") @Expose var statusCode: Int,
    @SerializedName("data") @Expose var data: MutableList<PlaceModel>
){
    data class PlaceModel(
        @SerializedName("name") @Expose var name: String,
        @SerializedName("location") @Expose var location: String,
        @SerializedName("image") @Expose var image: String
    )
}