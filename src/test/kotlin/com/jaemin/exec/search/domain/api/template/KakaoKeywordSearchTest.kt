package com.jaemin.exec.search.domain.api.template

import com.jaemin.exec.search.domain.api.kakao.KakaoKeywordSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchSort
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@ExtendWith(MockKExtension::class)
@SpringBootTest
class KakaoKeywordSearchTest {

    @Autowired
    private lateinit var kakaoKeywordSearch: KakaoKeywordSearch

    @DisplayName("카카오 키워드 요청")
    @Test
    fun kakaoKeywordSearchTest() {
        val searchRequest = SearchRequest(
            page = 1,
            keyword = "주식",
            display = 5,
            sort = SearchSort.COMMENT
        )
        assertDoesNotThrow {
            kakaoKeywordSearch.search(searchRequest)
        }
    }
}