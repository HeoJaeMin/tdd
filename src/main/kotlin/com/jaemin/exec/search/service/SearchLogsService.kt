package com.jaemin.exec.search.service

import com.jaemin.exec.search.dto.NaverSearch
import com.jaemin.exec.search.entity.QSearchLogs
import com.jaemin.exec.search.entity.SearchLogs
import com.jaemin.exec.search.repository.SearchLogsRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.http.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.yaml.snakeyaml.util.UriEncoder
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

    fun search(keyword: String): NaverSearch? {
        val template = RestTemplate()
        val query: String = UriEncoder.encode(keyword)

        val urlStr =
            "https://openapi.naver.com/v1/search/local.json?query=${query}&display=10&start=1&sort=random"
        val uri: URI = URI.create(urlStr)

        val headers = HttpHeaders()
        headers.set("X-Naver-Client-Id", "yZl5YZH4Hzz9A1oGsCKl")
        headers.set("X-Naver-Client-Secret", "cBeXFVmzlW")
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())

        val entity: HttpEntity<Any> = HttpEntity<Any>("parameters", headers)

        val search: ResponseEntity<NaverSearch> =
            template.exchange(uri, HttpMethod.GET, entity, NaverSearch::class.java)

        return search.body
    }
}
