package com.example.liverpoolltest.data.models

import com.google.gson.annotations.SerializedName

data class Records(
    @SerializedName("productDisplayName") val productDisplayName:String,
    @SerializedName("listPrice") val listPrice:Double,
    @SerializedName("promoPrice") val promoPrice:Double,
    @SerializedName("variantsColor") val variantsColor: List<VariantColor>,
    @SerializedName("smImage") val smImage:String
)
