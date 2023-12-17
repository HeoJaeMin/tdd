package com.jaemin.exec.search.application

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.search.domain.api.naver.NaverKeywordSearch
import com.jaemin.exec.search.domain.dto.naver.NaverSearch
import com.jaemin.exec.search.domain.repository.jpa.SearchLogsRepository
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val searchLogsRepository: SearchLogsRepository,
    private val naverKeywordSearch: NaverKeywordSearch
) {
    fun search(searchRequest: SearchRequest): ResponseTemplate<SearchResponse> {
        searchRequest.validate()
        val result: ResponseEntity<NaverSearch> = naverKeywordSearch.search(searchRequest)

        if (!result.statusCode.isError) {
            return ResponseTemplate(
                true,
                result.body?.toSearchResponse()
            )
        }

        //카카오
        print("Search Kakao")
        if (result.statusCode.isError) {
            print("Search Database")
            return ResponseTemplate(
                true,
                null
            )
        } else {
            return ResponseTemplate(
                true,
                null
            )
        }
    }
}
