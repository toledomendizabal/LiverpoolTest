package com.example.liverpoolltest.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://shoppapp.liverpool.com.mx/appclienteservices/services/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}