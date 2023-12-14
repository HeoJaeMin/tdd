package com.jaemin.exec.search.infrastructure.api.kakao

import com.jaemin.exec.search.infrastructure.api.factory.KakaoApiFactory
import com.jaemin.exec.search.infrastructure.dto.naver.NaverSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchResponse
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import java.net.URI

class KakaoKeywordSearch : KakaoApiFactory() {
    companion object {
        const val REQUEST = "https://dapi.kakao.com/v2/local/search/keyword.json"
    }

    fun search(searchRequest: SearchRequest): ResponseEntity<SearchResponse> {
        val template = RestTemplate()
        val requestParams = HashMap<String, String>()

        requestParams["query"] = searchRequest.keyword
        requestParams["size"] = searchRequest.display.toString()
        requestParams["page"] = searchRequest.page.toString()
        requestParams["sort"] = "accuracy"
        val uri: URI = URI.create(super.setRequestParams(REQUEST, requestParams))

        val entity = setHeader()

        val response = template.exchange(uri, HttpMethod.GET, entity, NaverSearch::class.java)

        if (response.statusCode.value() != 200) {
            return ResponseEntity.status(response.statusCode).body(
                SearchResponse(
                    errorMessage = response.body?.errorMessage
                )
            )
        }

        val contents: NaverSearch? = response.body


        return ResponseEntity.status(response.statusCode).body(contents!!.toSearchResponse())
    }


}