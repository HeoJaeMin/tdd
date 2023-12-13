package com.jaemin.exec.search.presentation.controller

import com.jaemin.exec.search.application.SearchService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/search")
class SearchController(
    private val searchService: SearchService
)