package com.jaemin.exec.keyword.presentation

import com.jaemin.exec.core.response.ResponseTemplate
import com.jaemin.exec.keyword.application.KeywordService
import com.jaemin.exec.keyword.infrastructure.Keyword
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/keyword")
class KeywordController(
    private val keywordService: KeywordService,
) {
    @GetMapping("/top")
    fun top(): ResponseTemplate<List<Keyword>> {
        return keywordService.top()
    }
}