package com.example.liverpoolltest.data.models

import com.google.gson.annotations.SerializedName

data class ProdctsResponse(
    @SerializedName("status") val status :Status,
    @SerializedName("pageType") val pageType:String,
    @SerializedName("plpResults") val plpResults:PlpResponse
)
