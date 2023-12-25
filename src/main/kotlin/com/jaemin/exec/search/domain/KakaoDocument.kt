package com.jaemin.exec.search.domain

import com.jaemin.exec.search.presentation.SearchResponseDetail

data class KakaoDocument(
    val id: String,
    val placeName: String?,
    val categoryName: String?,
    val categoryGroupCode: String?,
    val categoryGroupName: String?,
    val phone: String?,
    val addressName: String?,
    val roadAddressName: String?,
    val x: String?,
    val y: String?,
    val placeUrl: String?,
    val distance: String?
) {
    fun toSearchResponseDetail(): SearchResponseDetail {
        return SearchResponseDetail(
            title = placeName ?: "",
            link = placeUrl ?: "",
            category = categoryName ?: "",
            address = addressName ?: "",
            roadAddress = roadAddressName ?: "",
            telephone = phone ?: ""
        )
    }
}