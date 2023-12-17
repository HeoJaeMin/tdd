package com.jaemin.exec.search.domain.dto.naver

import com.jaemin.exec.search.presentation.dto.SearchResponseDetail

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
){
    fun toSearchResponseDetail(): SearchResponseDetail{
        return SearchResponseDetail(
            title = title,
            link= link,
            category = category,
            address = address,
            roadAddress = roadAddress,
            telephone = telephone
        )
    }
}