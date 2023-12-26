package com.jaemin.exec.search.domain

import com.jaemin.exec.search.infrastructure.SearchLogsDetailRepository
import com.jaemin.exec.search.infrastructure.SearchLogsRepository
import com.jaemin.exec.search.presentation.SearchRequest
import com.jaemin.exec.search.presentation.SearchResponse
import org.springframework.stereotype.Component

@Component
class SearchLogsProvider(
    private val searchLogsRepository: SearchLogsRepository,
    private val searchLogsDetailRepository: SearchLogsDetailRepository,
) {

    fun saveKeywordResponse(request: SearchRequest, response: SearchResponse) {
        val converted = response.convert(request)

        searchLogsRepository.save(converted.logs)

        converted.detail.forEach { it.logId = converted.logs.logId }
        searchLogsDetailRepository.saveAll(converted.detail)
    }
}