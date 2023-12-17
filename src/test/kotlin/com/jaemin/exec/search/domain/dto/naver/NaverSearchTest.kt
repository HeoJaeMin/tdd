package com.jaemin.exec.search.domain.dto.naver

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NaverSearchTest {

    @DisplayName("이렇게 해도 오류 안나나?")
    @Test
    fun naverSearchTest1() {
        val naverSearch = NaverSearch(
            null,
            null,
            null,
            ArrayList(),
            null
        )

        naverSearch.toSearchResponse()
    }
}