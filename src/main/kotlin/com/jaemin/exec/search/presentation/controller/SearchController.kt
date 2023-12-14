package com.jaemin.exec.search.presentation.controller

import com.jaemin.exec.search.application.SearchService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/search")
class SearchController(
    private val searchService: SearchService
) {
//    @GetMapping
//    fun search(
//        @RequestParam keyword: String,
//        @RequestParam sort: String,
//        @RequestParam page: Int,
//        @RequestParam display: Int
//    ): ResponseEntity<SearchResponse> {
//        return searchService.search(
//            SearchRequest(
//                keyword = keyword,
//                sort = SearchSort.valueOf(sort),
//                page = page,
//                display = display
//            )
//        )
//    }
}