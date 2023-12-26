package com.jaemin.exec.search.application

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.search.domain.SearchLogsProvider
import com.jaemin.exec.search.domain.SearchProvider
import com.jaemin.exec.search.presentation.SearchRequest
import com.jaemin.exec.search.presentation.SearchResponse
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val searchProvider: SearchProvider,
    private val searchLogsProvider: SearchLogsProvider,
) {
    fun search(searchRequest: SearchRequest): ResponseTemplate<SearchResponse> {
        searchRequest.validate()
        val result: ResponseTemplate<SearchResponse> = searchProvider.search(searchRequest)

        searchLogsProvider.saveKeywordResponse(searchRequest, result.result!!)

        return result
    }
}