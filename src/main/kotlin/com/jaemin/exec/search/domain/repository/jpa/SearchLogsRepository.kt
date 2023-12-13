package com.jaemin.exec.search.domain.repository.jpa

import com.jaemin.exec.search.domain.table.SearchLogs
import org.springframework.data.jpa.repository.JpaRepository

interface SearchLogsRepository : JpaRepository<SearchLogs, Int>