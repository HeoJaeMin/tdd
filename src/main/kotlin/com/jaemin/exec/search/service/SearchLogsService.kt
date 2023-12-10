package com.jaemin.exec.search.service

import com.jaemin.exec.search.entity.QSearchLogs
import com.jaemin.exec.search.entity.SearchLogs
import com.jaemin.exec.search.repository.SearchLogsRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

@Service
class SearchLogsService(
    private val searchLogsRepository: SearchLogsRepository,
    private val entityManager: EntityManager
) {

    fun getLogsByQueryDsl(): MutableList<SearchLogs>? {
        save()
        val searchLogs = QSearchLogs.searchLogs
        val jpaQueryFactory = JPAQueryFactory(entityManager)
        return jpaQueryFactory.selectFrom(searchLogs).fetch()
    }

    fun getLogsByRepos(): MutableList<SearchLogs> {
        save()
        return searchLogsRepository.findAll()
    }

    fun save() {
        val searchLogs = SearchLogs(null)
        searchLogsRepository.save(searchLogs)
    }

    fun search() {
        val template: RestTemplate = RestTemplate()
        val urlStr: String = "v1/search/local.json"
        val uri: URI = URI.create(urlStr)
    }
}
