package com.jaemin.exec.search.application

import com.jaemin.exec.search.domain.repository.jpa.SearchLogsRepository
import org.springframework.stereotype.Service

@Service
class SearchService(
    private val searchLogsRepository: SearchLogsRepository
)
