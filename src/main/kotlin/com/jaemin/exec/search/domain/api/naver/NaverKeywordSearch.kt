package com.jaemin.exec.search.domain.api.naver

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.search.domain.api.template.impl.NaverApiTemplate
import com.jaemin.exec.search.domain.dto.naver.NaverSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchResponse
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service

@Service
class NaverKeywordSearch(
    private val naverApiTemplate: NaverApiTemplate<NaverSearch>
) {

    companion object {
        const val BASE_URL = "https://openapi.naver.com/v1/search/local.json"
    }


    @CircuitBreaker(name = "naverKeywordSearch", fallbackMethod = "kakaoKeywordSearch")
    fun search(searchRequest: SearchRequest): ResponseTemplate<SearchResponse> {
        val requestParams = HashMap<String, String>()

        requestParams["query"] = searchRequest.keyword
        requestParams["display"] = searchRequest.display.toString()
        requestParams["start"] = searchRequest.page.toString()
        requestParams["sort"] = searchRequest.sort.value

        val response = naverApiTemplate.get(BASE_URL, requestParams, NaverSearch::class.java)

        if (response.statusCode.isError) {
            throw RuntimeException("네이버 오류!")
        }

        return ResponseTemplate(
            true,
            response.body?.toSearchResponse()
        )
    }
}