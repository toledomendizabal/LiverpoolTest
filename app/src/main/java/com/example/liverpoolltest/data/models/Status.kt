package com.example.liverpoolltest.data.models

import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("status") var status:String,
    @SerializedName("statusCode") var statusCode:Int
)
