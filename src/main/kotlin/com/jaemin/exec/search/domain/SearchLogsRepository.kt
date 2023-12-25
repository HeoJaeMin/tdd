package com.jaemin.exec.search.domain

import com.jaemin.exec.search.infrastructure.SearchLogs
import org.springframework.data.jpa.repository.JpaRepository

interface SearchLogsRepository : JpaRepository<SearchLogs, Int>