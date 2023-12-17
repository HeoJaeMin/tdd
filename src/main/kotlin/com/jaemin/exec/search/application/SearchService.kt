package com.jaemin.exec.search.application

import com.jaemin.exec.search.domain.api.naver.NaverKeywordSearch
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
    fun search(searchRequest: SearchRequest): ResponseEntity<SearchResponse>? {
        var result: ResponseEntity<SearchResponse> = naverKeywordSearch.search(searchRequest)

        if (result.statusCode.value() != 200) {
            //카카오
            print("Search Kakao")
            if (result.statusCode.value() != 200) {
                print("Search Database")
                result = ResponseEntity.ok(null)
            }

        }

        return result
    }
}
