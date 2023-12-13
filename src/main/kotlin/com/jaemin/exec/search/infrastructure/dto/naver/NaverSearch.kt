package com.jaemin.exec.search.infrastructure.dto.naver

data class NaverSearch(
    val total: Int?,
    val start: Int?,
    val display: Int?,
    val items: MutableList<NaverSearchItems>?,
    val errorMessage: String?
)