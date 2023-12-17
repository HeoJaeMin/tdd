package com.jaemin.exec.search.domain.api.naver

import com.jaemin.exec.search.domain.api.factory.template.impl.NaverTemplateFactory
import com.jaemin.exec.search.domain.dto.naver.NaverSearch
import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.yaml.snakeyaml.util.UriEncoder
import java.net.URI

@Service
class NaverKeywordSearch (
   private val naverTemplateFactory: NaverTemplateFactory
) {

    companion object {
        const val BASE_URL = "https://openapi.naver.com/v1/search/local.json"
    }

    fun search(searchRequest: SearchRequest): ResponseEntity<SearchResponse> {
        val template = naverTemplateFactory.getRestTemplate();
        val requestParams = HashMap<String, String>()

        requestParams["query"] = searchRequest.keyword
        requestParams["display"] = searchRequest.display.toString()
        requestParams["start"] = searchRequest.page.toString()
        requestParams["sort"] = searchRequest.sort.value

        val uri: URI = URI.create(setRequestParams(BASE_URL, requestParams))

        val response = template.getForEntity(uri, NaverSearch::class.java)

        if (response.statusCode.value() != 200) {
            return ResponseEntity.status(response.statusCode).body(
                SearchResponse(
                    errorMessage = response.body?.errorMessage
                )
            )
        }

        val contents : NaverSearch? = response.body;


        return ResponseEntity.status(response.statusCode).body(contents!!.toSearchResponse())
    }

    fun setRequestParams(url: String, requestParams: Map<String, String>): String {

        var result = url

        for (a in requestParams.entries) {
            val requestParam = "${a.key}=${UriEncoder.encode(a.value)}"

            if (result.contains("?")) {
                result = result.plus("&")
            } else {
                result = result.plus("?")
            }
            result = result.plus(requestParam)
        }
        return result
    }
}