package com.example.liverpoolltest.ui.viewmodel

import android.widget.SearchView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.liverpoolltest.data.models.Records
import com.example.liverpoolltest.domain.GetListSortUseCase
import com.example.liverpoolltest.domain.GetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel  : ViewModel() {

    private val getListUseCase= GetListUseCase()
    private val getListSortUseCase= GetListSortUseCase()
    private val _listProducts=MutableLiveData<List<Records>>()
    val listProducts:LiveData<List<Records>> = _listProducts
    var page=1
    var search="celular"
    private val sortProduct=false

    fun getList(){
        _listProducts.value= emptyList()
        viewModelScope.launch(Dispatchers.IO) {
            val result=getListUseCase(search,page)
            if (!result.isEmpty()){
                _listProducts.postValue(result)
            }
        }
    }
    fun getListSortMin(){
        viewModelScope.launch(Dispatchers.IO) {
            _listProducts.value= emptyList()
            var result= emptyList<Records>()
            if (!sortProduct) {
                 result = getListSortUseCase(search, page, 0)
            }else{
                 result = getListSortUseCase(search, page, 1)
            }
            if (!result.isEmpty()){
                _listProducts.postValue(result)
            }
        }
    }


}