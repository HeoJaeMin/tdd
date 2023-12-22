package com.jaemin.exec.search.application

import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchSort
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@ExtendWith(MockKExtension::class)
class SearchServiceTest {

    @Autowired
    private lateinit var searchService: SearchService

    @Test
    fun test() {
        searchService.search(
            SearchRequest(
                sort = SearchSort.COMMENT,
                page = 1,
                display = 5,
                keyword = "여의도"
            )
        )
    }
}