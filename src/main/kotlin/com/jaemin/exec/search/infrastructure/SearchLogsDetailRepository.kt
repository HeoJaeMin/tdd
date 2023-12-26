package com.jaemin.exec.search.infrastructure

import org.springframework.data.jpa.repository.JpaRepository

interface SearchLogsDetailRepository : JpaRepository<SearchLogsDetail, Int>