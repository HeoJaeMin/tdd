package com.jaemin.exec.search.domain.provider

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.search.domain.api.kakao.KakaoKeywordSearch
import com.jaemin.exec.search.domain.api.naver.NaverKeywordSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchResponse
import io.vavr.control.Try
import org.springframework.stereotype.Component

@Component
class SearchProvider(
    private val naverKeywordSearch: NaverKeywordSearch,
    private val kakaoKeywordSearch: KakaoKeywordSearch,
) {

    fun search(searchRequest: SearchRequest): ResponseTemplate<SearchResponse>? {
        return Try.of { naverKeywordSearch.search(searchRequest) }.recover { kakaoKeywordSearch.search(searchRequest) }
            .get()
    }
}
