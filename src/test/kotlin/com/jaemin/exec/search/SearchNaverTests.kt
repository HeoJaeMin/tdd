package com.jaemin.exec.search

import com.jaemin.exec.search.infrastructure.dto.naver.NaverSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchSort
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.yaml.snakeyaml.util.UriEncoder
import java.net.URI

@SpringBootTest
class SearchNaverTests {


    @Test
    fun search() {
        val searchRequest = SearchRequest(
            keyword = "123",
            page = 1,
            sort = SearchSort.valueOf(value = "COMMENT"),
            display = 5
        )
        val template = RestTemplate()
        val query: String = UriEncoder.encode(searchRequest.keyword)

        val urlStr =
            "https://openapi.naver.com/v1/search/local.json?query=${query}&display=${searchRequest.display}&start=${searchRequest.page}&sort=${searchRequest.sort}"
        val uri: URI = URI.create(urlStr)

        val headers = HttpHeaders()
        headers.set("X-Naver-Client-Id", "yZl5YZH4Hzz9A1oGsCKl")
        headers.set("X-Naver-Client-Secret", "cBeXFVmzl")
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())

        val entity: HttpEntity<Any> = HttpEntity<Any>("parameters", headers)
        val response = template.exchange(uri, HttpMethod.GET, entity, NaverSearch::class.java)

        assert(response.statusCode.value() == 200)
    }
}