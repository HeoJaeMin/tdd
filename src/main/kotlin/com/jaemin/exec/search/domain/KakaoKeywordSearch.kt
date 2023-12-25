package com.jaemin.exec.search.domain

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.search.infrastructure.KakaoApiTemplate
import com.jaemin.exec.search.presentation.SearchRequest
import com.jaemin.exec.search.presentation.SearchResponse
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service

@Service
class KakaoKeywordSearch(
    private val kakaoApiTemplate: KakaoApiTemplate<KakaoSearch>,
) {
    companion object {
        const val BASE_URL = "https://dapi.kakao.com/v2/local/search/keyword.json"
    }

    @CircuitBreaker(name="kakaoSearch")
    fun search(searchRequest: SearchRequest): ResponseTemplate<SearchResponse> {
        val requestParams = HashMap<String, String>()

        requestParams["query"] = searchRequest.keyword
        requestParams["size"] = searchRequest.display.toString()
        requestParams["page"] = searchRequest.page.toString()

        val response = kakaoApiTemplate.get(BASE_URL, requestParams, KakaoSearch::class.java)

        if (response.statusCode.isError) {
            throw RuntimeException("카카오 오류!")
        }

        return ResponseTemplate(
            true,
            response.body?.toSearchResponse(searchRequest)
        )
    }
}