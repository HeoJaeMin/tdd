package com.jaemin.exec.search.domain

import com.jaemin.exec.search.domain.NaverKeywordSearch
import com.jaemin.exec.search.presentation.SearchRequest
import com.jaemin.exec.search.presentation.SearchSort
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NaverKeywordSearchTest {
    @Autowired
    private lateinit var naverKeywordSearch: NaverKeywordSearch

    @DisplayName("네이버 키워드 요청")
    @Test
    fun naverKeywordSearchTest1() {
        assertDoesNotThrow {
            naverKeywordSearch.search(
                SearchRequest(
                    page = 1,
                    keyword = "주식",
                    display = 5,
                    sort = SearchSort.COMMENT
                )
            )
        }
    }
}