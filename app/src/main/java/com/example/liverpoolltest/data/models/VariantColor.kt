package com.example.liverpoolltest.data.models

import com.google.gson.annotations.SerializedName

data class VariantColor(
    @SerializedName("colorName") val colorName: String,
    @SerializedName("colorHex") val colorHex: String,
    @SerializedName("colorImageURL") val colorImageURL: String,
    @SerializedName("colorMainURL") val colorMainURL: String?,
    @SerializedName("skuId") val skuId: String?,
    @SerializedName("galleryImages") val galleryImages: String?
)
