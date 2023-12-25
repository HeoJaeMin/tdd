package com.jaemin.exec.search.domain

import com.jaemin.exec.search.presentation.SearchResponse
import org.springframework.context.ApplicationEvent

class SearchEvent(
    searchResponse: SearchResponse,
) : ApplicationEvent(searchResponse)