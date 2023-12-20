package com.jaemin.exec.search.domain.dto.kakao

import com.jaemin.exec.search.presentation.dto.SearchRequest
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class KakaoSearchTest {
    @DisplayName("카카오 키워드 응답 mapper")
    @Test
    fun kakaoSearchTest1() {
        val searchRequest = mockk<SearchRequest>(relaxed = true)
        val kakaoSearch = mockk<KakaoSearch>(relaxed = true)

        kakaoSearch.toSearchResponse(searchRequest)
    }
}