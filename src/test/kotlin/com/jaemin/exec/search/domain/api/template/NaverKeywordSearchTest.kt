package com.jaemin.exec.search.domain.api.template

import com.jaemin.exec.search.domain.api.naver.NaverKeywordSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchSort
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus

@SpringBootTest
class NaverKeywordSearchTest {
    @Autowired
    private lateinit var naverKeywordSearch: NaverKeywordSearch

    @DisplayName("응답값이 404 Not_Found 또는 401 Un_Authorized 일 경우 오류를 반환한다.")
    @Test
    fun naverKeywordSearchTest1() {
        val response = naverKeywordSearch.search(
            SearchRequest(
                page = 1,
                keyword = "주식",
                display = 5,
                sort = SearchSort.COMMENT
            )
        )

        assert(response.statusCode != HttpStatus.NOT_FOUND && response.statusCode != HttpStatus.UNAUTHORIZED)
    }
}