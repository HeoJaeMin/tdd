package com.jaemin.exec.search.domain

import com.jaemin.exec.keyword.infrastructure.Keyword
import com.jaemin.exec.search.presentation.SearchRequest
import com.jaemin.exec.search.presentation.SearchResponse
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CustomSearchLogsRepository {

    fun findKeywordTop10(): Optional<List<Keyword>>
    fun findSearchResultFromLog(request: SearchRequest): SearchResponse
}