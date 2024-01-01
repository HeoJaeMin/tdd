package com.jaemin.exec.search.domain

import com.jaemin.exec.keyword.infrastructure.Keyword
import com.jaemin.exec.search.infrastructure.SearchLogsDetailRepository
import com.jaemin.exec.search.infrastructure.SearchLogsRepository
import com.jaemin.exec.search.presentation.SearchRequest
import com.jaemin.exec.search.presentation.SearchResponse
import org.springframework.stereotype.Component
import java.util.*

@Component
class SearchLogsProvider(
    private val searchLogsRepository: SearchLogsRepository,
    private val searchLogsDetailRepository: SearchLogsDetailRepository,
    private val customSearchLogsRepository: CustomSearchLogsRepository,
) {

    fun saveKeywordResponse(request: SearchRequest, response: SearchResponse) {
        val converted = response.convert(request)

        searchLogsRepository.save(converted.logs)

        converted.detail.forEach { it.logId = converted.logs.logId }
        searchLogsDetailRepository.saveAll(converted.detail)
    }

    fun findKeywordTop10(): Optional<List<Keyword>> {
        return customSearchLogsRepository.findKeywordTop10()
    }

    fun findSearchResultFromLog(request: SearchRequest): SearchResponse {
        return customSearchLogsRepository.findSearchResultFromLog(request)
    }
}