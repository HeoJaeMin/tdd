package com.jaemin.exec.search.presentation

import com.jaemin.exec.search.presentation.SearchRequest
import com.jaemin.exec.search.presentation.SearchSort
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SearchRequestTest {

    @DisplayName("keyword가 없으면 오류를 발생한다.")
    @Test
    fun searchRequestValidateTest1() {
        val searchRequest = SearchRequest(
            sort = SearchSort.COMMENT,
            page = 1,
            keyword = "",
            display = 1
        )

        assertThrows<RuntimeException> { searchRequest.validate() }
    }

    @DisplayName("page가 1보다 작으면 오류를 발생한다.")
    @Test
    fun searchRequestValidateTest2() {
        val searchRequest = SearchRequest(
            sort = SearchSort.COMMENT,
            page = 0,
            keyword = "주식",
            display = 1
        )

        assertThrows<RuntimeException> { searchRequest.validate() }
    }

    @DisplayName("검색 크기가 100보다 크면 오류를 발생한다.")
    @Test
    fun searchRequestValidateTest3() {
        val searchRequest = SearchRequest(
            sort = SearchSort.COMMENT,
            page = 1,
            keyword = "주식",
            display = 101
        )

        assertThrows<RuntimeException> { searchRequest.validate() }
    }

    @DisplayName("검색 크기가 0과 같거나 작으면 오류를 발생한다.")
    @Test
    fun searchRequestValidateTest4() {
        val searchRequest = SearchRequest(
            sort = SearchSort.COMMENT,
            page = 1,
            keyword = "주식",
            display = 0
        )

        assertThrows<RuntimeException> { searchRequest.validate() }
    }
}