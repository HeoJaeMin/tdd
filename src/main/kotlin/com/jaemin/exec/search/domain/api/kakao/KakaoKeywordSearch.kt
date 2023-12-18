package com.jaemin.exec.search.domain.api.kakao

import com.jaemin.exec.search.domain.api.template.impl.KakaoApiTemplate
import com.jaemin.exec.search.domain.dto.kakao.KakaoSearch
import org.springframework.stereotype.Service

@Service
class KakaoKeywordSearch(
    private val kakaoApiTemplate: KakaoApiTemplate<KakaoSearch>
)