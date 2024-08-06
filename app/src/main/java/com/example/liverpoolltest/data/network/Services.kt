package com.example.liverpoolltest.data.network

import android.util.Log
import com.example.liverpoolltest.core.RetrofitHelper
import com.example.liverpoolltest.data.models.ProdctsResponse
import com.example.liverpoolltest.data.models.Records
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class Services{

    private val retrofit=RetrofitHelper.getRetrofit()
    suspend fun getList(search: String, page: Int):List<Records> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(AppClient::class.java).listProducts(search, page)
            Log.d("response", response.toString())
            response.body()?.plpResults?.records ?: emptyList()
        }
    }
    suspend fun getListSort(search:String,page: Int,sort:Int):List<Records>{
        return withContext(Dispatchers.IO){
            val response=retrofit.create(AppClient::class.java).listProductsSort(search,page,sort)
            response.body()?.plpResults?.records ?: emptyList()
        }
    }
}