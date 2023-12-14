package com.jaemin.exec.search.presentation.dto

data class SearchResponse(
    val total: Int?,
    val pageNumber: Int?,
    val pageSize: Int?,
    val isLast: Boolean?,
    val content: List<SearchResponseDetail>?,
    val errorMessage: String?
) {
    constructor(
        total: Int?,
        pageNumber: Int?,
        pageSize: Int?,
        isLast: Boolean?,
        content: List<SearchResponseDetail>
    ) : this(total, pageNumber, pageSize, isLast, content, null)

    constructor(
        errorMessage: String?
    ) : this(null, null, null, null, null, errorMessage)
}