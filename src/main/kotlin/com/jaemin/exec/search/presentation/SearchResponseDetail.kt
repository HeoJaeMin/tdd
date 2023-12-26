package com.jaemin.exec.search.presentation

import com.jaemin.exec.search.infrastructure.SearchLogsDetail

data class SearchResponseDetail(
    val title: String,
    val link: String,
    val category: String,
    val address: String,
    val roadAddress: String,
    val telephone: String,
) {
    fun convert(): SearchLogsDetail {
        return SearchLogsDetail(
            null,
            title,
            link,
            category,
            address,
            roadAddress,
            telephone
        )
    }
}