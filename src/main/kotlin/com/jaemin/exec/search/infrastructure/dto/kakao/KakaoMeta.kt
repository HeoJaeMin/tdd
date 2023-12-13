package com.jaemin.exec.search.infrastructure.dto.kakao


data class KakaoMeta(
    val sameName: KakaoMetaSameName,
    val pageableCount: Int,
    val totalCount: Int,
    val isEnd: Boolean,
    val documents: List<KakaoDocument>
)