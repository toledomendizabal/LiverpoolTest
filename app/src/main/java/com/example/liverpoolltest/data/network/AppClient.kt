package com.example.liverpoolltest.data.network

import com.example.liverpoolltest.data.models.ProdctsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppClient {

    @GET("plp")
    suspend fun listProducts(
        @Query("search-string")  search:String,
        @Query("page-number")  page:Int
    ): Response<ProdctsResponse>

    @GET("plp")
    suspend fun listProductsSort(
        @Query("search-string")  search:String,
        @Query("page-number")  page:Int,
        @Query("minSortPrice") sort:Int
    ): Response<ProdctsResponse>
}