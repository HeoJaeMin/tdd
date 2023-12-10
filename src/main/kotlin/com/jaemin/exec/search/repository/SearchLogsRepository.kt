package com.jaemin.exec.search.repository

import com.jaemin.exec.search.entity.SearchLogs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SearchLogsRepository: JpaRepository<SearchLogs, Int> {
}