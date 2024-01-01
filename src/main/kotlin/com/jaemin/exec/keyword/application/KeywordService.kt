package com.jaemin.exec.keyword.application

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.keyword.domain.KeywordProvider
import com.jaemin.exec.keyword.infrastructure.Keyword
import org.springframework.stereotype.Service

@Service
class KeywordService(
    private val keywordProvider: KeywordProvider,
) {
    fun top(): ResponseTemplate<List<Keyword>> {
        return ResponseTemplate(
            result = keywordProvider.findAll(),
            success = true
        )
    }
}