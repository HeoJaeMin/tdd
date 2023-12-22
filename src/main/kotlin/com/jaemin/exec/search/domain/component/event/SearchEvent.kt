package com.jaemin.exec.search.domain.component.event

import com.jaemin.exec.search.presentation.dto.SearchResponse
import org.springframework.context.ApplicationEvent

class SearchEvent(
    searchResponse: SearchResponse,
) : ApplicationEvent(searchResponse)