package com.jaemin.exec.search.presentation.dto

data class SearchRequest(
    val keyword: String,
    val sort: SearchSort,
    val page: Int,
    val display: Int
)