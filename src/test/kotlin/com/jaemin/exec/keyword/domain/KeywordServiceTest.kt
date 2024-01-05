package com.jaemin.exec.keyword.domain

import com.jaemin.exec.keyword.application.KeywordService
import org.springframework.beans.factory.annotation.Autowired

class KeywordServiceTest {

    @Autowired
    private lateinit var keywordService: KeywordService

    //@Test
    fun keywordSearchTest() {
        keywordService.top()
    }
}