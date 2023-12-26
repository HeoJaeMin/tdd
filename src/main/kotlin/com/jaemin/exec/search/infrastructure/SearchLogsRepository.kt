package com.jaemin.exec.search.infrastructure

import org.springframework.data.jpa.repository.JpaRepository

interface SearchLogsRepository : JpaRepository<SearchLogs, Int>