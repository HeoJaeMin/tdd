package com.jaemin.exec.search.application

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.search.domain.provider.SearchProvider
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchResponse
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val searchProvider: SearchProvider
) {
    fun search(searchRequest: SearchRequest): ResponseTemplate<SearchResponse> {
        searchRequest.validate()
        val result: ResponseTemplate<SearchResponse> = searchProvider.search(searchRequest)!!

        return result
    }
}
