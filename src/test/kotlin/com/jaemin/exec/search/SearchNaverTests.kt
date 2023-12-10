package com.jaemin.exec.search

import com.jaemin.exec.search.service.SearchLogsService
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SearchNaverTests(
    private val searchLogsService: SearchLogsService
) {


    @Test
    fun searchNaver() {
        val keyword = "아무거나"
        searchLogsService.search(keyword)
    }
}