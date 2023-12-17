package com.jaemin.exec.search.domain.dto.kakao

data class KakaoDocument(
    val id: String,
    val placeName: String,
    val categoryName: String,
    val categoryGroupCode: String,
    val categoryGroupName: String,
    val phone: String,
    val addressName: String,
    val roadAddressName: String,
    val x: String,
    val y: String,
    val placeUrl: String,
    val distance: String
)