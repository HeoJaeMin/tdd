package com.jaemin.exec.search.domain

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.search.presentation.SearchRequest
import com.jaemin.exec.search.presentation.SearchResponse
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Component

@Component
class SearchProvider(
    private val naverKeywordSearch: NaverKeywordSearch,
    private val kakaoKeywordSearch: KakaoKeywordSearch,
) {

    @CircuitBreaker(name = "search", fallbackMethod = "naverFallback")
    fun search(searchRequest: SearchRequest): ResponseTemplate<SearchResponse> {
        return naverKeywordSearch.search(searchRequest)
    }

    @CircuitBreaker(name = "naverFallback")
    fun naverFallback(searchRequest: SearchRequest, e: Throwable): ResponseTemplate<SearchResponse> {
        return kakaoKeywordSearch.search(searchRequest)
    }
}
