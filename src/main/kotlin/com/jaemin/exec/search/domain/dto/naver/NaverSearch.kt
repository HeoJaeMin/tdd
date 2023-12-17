package com.jaemin.exec.search.domain.dto.naver

import com.jaemin.exec.search.presentation.dto.SearchResponse
import com.jaemin.exec.search.presentation.dto.SearchResponseDetail
import java.util.*

data class NaverSearch(
    val total: Int?,
    val start: Int?,
    val display: Int?,
    val items: MutableList<NaverSearchItems>?,
    val errorMessage: String?
) {
    fun toSearchResponse(): SearchResponse {

        var content: ArrayList<SearchResponseDetail> = ArrayList<SearchResponseDetail>()

        if (Objects.isNull(items)) {
            content = ArrayList()
        } else {
            for (a in items!!) {
                content.add(
                    a.toSearchResponseDetail()
                )
            }
        }



        return SearchResponse(
            total = total,
            pageNumber = start,
            pageSize = display,
            isLast = if (!Objects.isNull(display) && !Objects.isNull(total)) display!!.div(total!!) + 1 == start else true,
            content = content
        )
    }
}