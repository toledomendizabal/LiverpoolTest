package com.example.liverpoolltest.domain

import com.example.liverpoolltest.data.RecordsRepository
import com.example.liverpoolltest.data.models.Records
import javax.inject.Inject

class GetListUseCase {
    private val records: RecordsRepository=RecordsRepository()
    suspend operator fun invoke(search: String, page: Int): List<Records> =
        records.getList(search, page)
}