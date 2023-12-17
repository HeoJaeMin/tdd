package com.jaemin.exec.search.domain.api.naver

import com.jaemin.exec.search.domain.api.template.impl.NaverApiTemplate
import com.jaemin.exec.search.domain.dto.naver.NaverSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class NaverKeywordSearch(
    private val naverApiTemplate: NaverApiTemplate<NaverSearch>
) {

    companion object {
        const val BASE_URL = "https://openapi.naver.com/v1/search/local.json"
    }

    fun search(searchRequest: SearchRequest): ResponseEntity<NaverSearch> {
        val requestParams = HashMap<String, String>()

        requestParams["query"] = searchRequest.keyword
        requestParams["display"] = searchRequest.display.toString()
        requestParams["start"] = searchRequest.page.toString()
        requestParams["sort"] = searchRequest.sort.value

        return naverApiTemplate.get(BASE_URL, requestParams, NaverSearch::class.java)
    }
}