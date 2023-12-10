package com.jaemin.exec.search.dto

data class NaverSearch(
    val total: Int,
    val start: Int,
    val display: Int,
    val items: MutableList<NaverSearchItems>
)