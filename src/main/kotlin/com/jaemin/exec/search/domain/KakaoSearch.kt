package com.jaemin.exec.search.domain

import com.jaemin.exec.search.presentation.SearchRequest
import com.jaemin.exec.search.presentation.SearchResponse
import com.jaemin.exec.search.presentation.SearchResponseDetail
import java.util.*


data class KakaoSearch(
    val meta: KakaoMeta,
    val documents: List<KakaoDocument>
) {
    fun toSearchResponse(searchRequest: SearchRequest): SearchResponse {
        val content: ArrayList<SearchResponseDetail> = ArrayList()

        if (!Objects.isNull(documents)) {
            for (a in documents) {
                content.add(
                    a.toSearchResponseDetail()
                )
            }
        }

        return SearchResponse(
            total = meta.pageableCount * searchRequest.display,
            pageNumber = meta.pageableCount,
            pageSize = searchRequest.display,
            isLast = meta.isEnd,
            content = content
        )
    }
}