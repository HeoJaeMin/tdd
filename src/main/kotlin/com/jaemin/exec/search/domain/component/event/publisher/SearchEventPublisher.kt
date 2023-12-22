package com.jaemin.exec.search.domain.component.event.publisher

import com.jaemin.exec.search.domain.component.event.SearchEvent
import com.jaemin.exec.search.presentation.dto.SearchResponse
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