package com.jaemin.exec.keyword.infrastructure

import org.springframework.data.jpa.repository.JpaRepository

interface KeywordRepository : JpaRepository<Keyword, String>