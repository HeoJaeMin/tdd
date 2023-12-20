package com.jaemin.exec.search.application

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.search.domain.api.naver.NaverKeywordSearch
import com.jaemin.exec.search.domain.repository.jpa.SearchLogsRepository
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchResponse
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val searchLogsRepository: SearchLogsRepository,
    private val naverKeywordSearch: NaverKeywordSearch
) {
    fun search(searchRequest: SearchRequest): ResponseTemplate<SearchResponse> {
        searchRequest.validate()
        val result: ResponseTemplate<SearchResponse> = naverKeywordSearch.search(searchRequest)

        return result
    }
}
