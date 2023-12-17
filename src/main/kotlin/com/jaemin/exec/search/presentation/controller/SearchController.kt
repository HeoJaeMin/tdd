package com.jaemin.exec.search.presentation.controller

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.search.application.SearchService
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchResponse
import com.jaemin.exec.search.presentation.dto.SearchSort
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/search")
class SearchController(
    private val searchService: SearchService
) {
    @GetMapping
    fun search(
        @RequestParam keyword: String,
        @RequestParam sort: String,
        @RequestParam page: Int,
        @RequestParam display: Int
    ): ResponseTemplate<SearchResponse> {
        return searchService.search(
            SearchRequest(
                keyword = keyword,
                sort = SearchSort.valueOf(sort),
                page = page,
                display = display
            )
        )
    }
}