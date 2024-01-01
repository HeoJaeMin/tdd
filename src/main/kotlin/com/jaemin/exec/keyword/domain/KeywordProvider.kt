package com.jaemin.exec.keyword.domain

import com.jaemin.exec.keyword.infrastructure.Keyword
import com.jaemin.exec.keyword.infrastructure.KeywordRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class KeywordProvider(
    private val keywordRepository: KeywordRepository,
) {

    fun findAll(): List<Keyword> {
        return keywordRepository.findAll()
    }

    @Transactional
    fun generateKeywordTop10(keywords: List<Keyword>) {
        keywordRepository.deleteAll()
        keywordRepository.saveAll(keywords)
    }
}