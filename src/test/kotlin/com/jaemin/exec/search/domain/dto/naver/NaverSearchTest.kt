package com.jaemin.exec.search.domain.dto.naver

import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest

@ExtendWith(MockKExtension::class)
@SpringBootTest
class NaverSearchTest {

    @DisplayName("네이버 키워드 응답 mapper")
    @Test
    fun naverSearchTest1() {
        val naverSearch = mockk<NaverSearch>(relaxed = true)
//            NaverSearch(
//                null,
//                null,
//                null,
//                null,
//                null
//            )

        naverSearch.toSearchResponse()
    }
}