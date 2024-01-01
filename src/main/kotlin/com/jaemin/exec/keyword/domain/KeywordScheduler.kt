package com.jaemin.exec.keyword.domain

import com.jaemin.exec.search.domain.SearchLogsProvider
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class KeywordScheduler(
    private val searchLogsProvider: SearchLogsProvider,
    private val keywordProvider: KeywordProvider,
) {
    @Scheduled(cron = "0 0/10 * * * * ")
    fun generateKeywordTop10() {
        val keywords = searchLogsProvider.findKeywordTop10().orElseThrow {
            RuntimeException("최근 인기 키워드가 없습니다.")
        }

        keywordProvider.generateKeywordTop10(keywords)
    }
}