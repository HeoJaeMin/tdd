package com.jaemin.exec.search.infrastructure

import com.jaemin.exec.keyword.infrastructure.Keyword
import com.jaemin.exec.search.domain.CustomSearchLogsRepository
import com.jaemin.exec.search.presentation.SearchRequest
import com.jaemin.exec.search.presentation.SearchResponse
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.*

@Repository
class CustomSearchLogsRepositoryImpl(
    private val entityManager: EntityManager,
    private val searchLogs: QSearchLogs = QSearchLogs.searchLogs,
    private val searchLogsDetail: QSearchLogsDetail = QSearchLogsDetail.searchLogsDetail,
) : CustomSearchLogsRepository {
    override fun findKeywordTop10(): Optional<List<Keyword>> {
        return Optional.of(
            JPAQueryFactory(entityManager).select(
                Projections.constructor(
                    Keyword::class.java,
                    searchLogs.keyword,
                    searchLogs.logId.count()
                )
            ).from(searchLogs)
                .where(searchLogs.searchAt.between(LocalDateTime.now().minusHours(1L), LocalDateTime.now()))
                .groupBy(searchLogs.keyword)
                .orderBy(
                    searchLogs.logId.count().desc()
                )
                .limit(10L).fetch()
        )
    }

    override fun findSearchResultFromLog(request: SearchRequest): SearchResponse {
        TODO("Not yet implemented")
    }
}