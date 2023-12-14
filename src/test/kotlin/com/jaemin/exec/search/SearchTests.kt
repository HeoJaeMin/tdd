package com.jaemin.exec.search

import com.jaemin.exec.search.infrastructure.api.naver.NaverKeywordSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchSort
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SearchTests {

    @Autowired
    private lateinit var naverKeywordSearch: NaverKeywordSearch

    @Test
    fun searchNaver() {
        val searchRequest = SearchRequest(
            keyword = "주식",
            page = 2,
            sort = SearchSort.valueOf(value = "COMMENT"),
            display = 5
        )
        val response = naverKeywordSearch.search(searchRequest)

        assert(response.statusCode.value() == 200)
    }
}