package com.jaemin.exec.search.presentation

import com.jaemin.exec.search.infrastructure.SearchLogs
import com.jaemin.exec.search.infrastructure.SearchLogsInfo

data class SearchResponse(
    val total: Int,
    val pageNumber: Int,
    val pageSize: Int,
    val isLast: Boolean,
    val content: List<SearchResponseDetail>,
) {

    fun convert(request: SearchRequest): SearchLogsInfo {
        return SearchLogsInfo(
            SearchLogs(
                keyword = request.keyword,
                total = this.total,
                pageNumber = this.pageNumber,
                isLast = if (this.isLast) "Y" else "N"
            ),
            content.stream().map { it.convert() }.toList()
        )
    }


}