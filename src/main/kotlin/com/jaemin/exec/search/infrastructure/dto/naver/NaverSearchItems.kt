package com.jaemin.exec.search.infrastructure.dto.naver

data class NaverSearchItems(
    val title: String,
    val link: String,
    val category: String,
    val description: String,
    val telephone: String,
    val address: String,
    val roadAddress: String,
    val mapx: Int,
    val mapy: Int
)