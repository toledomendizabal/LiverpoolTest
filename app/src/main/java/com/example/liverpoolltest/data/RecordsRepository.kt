package com.example.liverpoolltest.data

import com.example.liverpoolltest.data.models.ProdctsResponse
import com.example.liverpoolltest.data.models.Records
import com.example.liverpoolltest.data.network.Services
import javax.inject.Inject

class RecordsRepository {

    private val api:Services=Services()
    suspend fun getList(search :String, page:Int): List<Records>{
        return api.getList(search,page)
    }
    suspend fun getListSort(search:String,page: Int,sort:Int):List<Records>{
        return api.getListSort(search,page,sort)
    }
}