package com.jaemin.exec.search.domain

import com.jaemin.exec.search.presentation.SearchResponse
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class SearchEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
) {
    fun publishEvent(searchResponse: SearchResponse) {
        applicationEventPublisher.publishEvent(SearchEvent(searchResponse))
    }
}