package com.example.liverpoolltest.domain

import com.example.liverpoolltest.data.RecordsRepository
import com.example.liverpoolltest.data.models.Records
import javax.inject.Inject

class GetListSortUseCase {
    private val records: RecordsRepository=RecordsRepository()
    suspend operator fun invoke(search: String, page: Int, sort: Int):List<Records> =
        records.getListSort(search, page, sort)
}
