package com.example.liverpoolltest.data.models

import com.google.gson.annotations.SerializedName

data class PlpResponse(
    @SerializedName("records") val records:List<Records>,
)
