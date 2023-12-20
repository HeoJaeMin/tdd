package com.jaemin.exec.search.domain.dto.kakao

import com.jaemin.exec.search.presentation.dto.SearchRequest
import com.jaemin.exec.search.presentation.dto.SearchResponse
import com.jaemin.exec.search.presentation.dto.SearchResponseDetail
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