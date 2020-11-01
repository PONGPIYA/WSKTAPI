package com.example.wsktapi

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("jobNo") val jobNo: String,
    @SerializedName("truckLicense") val truckLicense: String,
    @SerializedName("province") val province: String,
    @SerializedName("truckType") val truckType: String,
    @SerializedName("routeDt") val routeDt: String,
    @SerializedName("routeCd") val routeCd: String,
    @SerializedName("logisticPointCd") val logisticPointCd: String,
    @SerializedName("arrivalDt") val arrivalDt: String,
    @SerializedName("departureDt") val departureDt: String
)