package com.jaemin.exec.search.controller

import com.jaemin.exec.search.dto.NaverSearch
import com.jaemin.exec.search.entity.SearchLogs
import com.jaemin.exec.search.service.SearchLogsService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/search-logs")
class SearchLogsController(
    private val searchLogsService: SearchLogsService
) {
    @GetMapping("/search-repo")
    fun search(): ResponseEntity<MutableList<SearchLogs>> {
        return ResponseEntity.ok(searchLogsService.getLogsByRepos())
    }

    @GetMapping("/search-qdl")
    fun searchQdl(): ResponseEntity<MutableList<SearchLogs>> {
        return ResponseEntity.ok(searchLogsService.getLogsByQueryDsl())
    }

    @GetMapping("/search")
    fun searchOut(@RequestParam(name = "keyword") keyword: String): ResponseEntity<NaverSearch?> {
        return ResponseEntity.ok(searchLogsService.search(keyword))
    }
}