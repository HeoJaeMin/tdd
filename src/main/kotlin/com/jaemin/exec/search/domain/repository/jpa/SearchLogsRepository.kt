package com.jaemin.exec.search.domain.repository.jpa

import com.jaemin.exec.search.domain.repository.querydsl.CustomSearchLogsRepository
import com.jaemin.exec.search.infrastructure.entity.SearchLogs
import org.springframework.data.jpa.repository.JpaRepository

interface SearchLogsRepository : JpaRepository<SearchLogs, Int>, CustomSearchLogsRepository