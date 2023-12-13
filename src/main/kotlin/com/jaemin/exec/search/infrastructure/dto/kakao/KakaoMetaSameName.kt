package com.jaemin.exec.search.infrastructure.dto.kakao

data class KakaoMetaSameName(
    val region: List<String>,
    val keyword: String,
    val selectedRegion: String
)