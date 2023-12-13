package com.jaemin.exec.search.infrastructure.api.naver

import com.jaemin.exec.search.infrastructure.api.factory.NaverApiFactory
import com.jaemin.exec.search.infrastructure.dto.naver.NaverSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchResponse
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

@Service
class NaverKeywordSearch : NaverApiFactory() {

    companion object {
        const val BASE_URL = "https://openapi.naver.com/v1/search/local.json"
    }

    fun search(searchRequest: SearchRequest): ResponseEntity<SearchResponse> {
        val template = RestTemplate()
        val requestParams = HashMap<String, String>()

        requestParams["query"] = searchRequest.keyword
        requestParams["display"] = searchRequest.display.toString()
        requestParams["start"] = searchRequest.page.toString()
        requestParams["sort"] = searchRequest.sort.value

        val uri: URI = URI.create(super.setRequestParams(BASE_URL, requestParams))

        val entity = setHeader()

        val response = template.exchange(uri, HttpMethod.GET, entity, NaverSearch::class.java)

        if (response.statusCode.value() != 200) {
            return ResponseEntity.status(response.statusCode).body(
                SearchResponse(
                    errorMessage = response.body?.errorMessage
                )
            )
        }

        val contents = response.body


        return ResponseEntity.status(response.statusCode).body(null)
    }
}