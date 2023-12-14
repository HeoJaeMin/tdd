package com.jaemin.exec.search

import com.jaemin.exec.search.infrastructure.api.naver.NaverKeywordSearch
import com.jaemin.exec.search.infrastructure.dto.naver.NaverSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchSort
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
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

    @Autowired
    private lateinit var naverKeywordSearch: NaverKeywordSearch

    @Test
    fun search() {
        val searchRequest = SearchRequest(
            keyword = "주식",
            page = 2,
            sort = SearchSort.valueOf(value = "COMMENT"),
            display = 5
        )
        val response = naverKeywordSearch.search(searchRequest)

        print(response.toString())

        assert(response.statusCode.value() == 200)
    }
}