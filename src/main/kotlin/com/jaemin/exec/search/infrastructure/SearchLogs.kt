package com.jaemin.exec.search.infrastructure

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class SearchLogs(
    @Id
    @Column(name = "logId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val logId: Int?,
    @Column(name = "keyword")
    val keyword: String,
    @Column(name = "total")
    val total: Int,
    @Column(name = "pageNumber")
    val pageNumber: Int,
    @Column(name = "isLast")
    val isLast: String,
    @Column(name = "searchAt")
    val searchAt: LocalDateTime,
) {
    constructor(keyword: String, total: Int, pageNumber: Int, isLast: String, searchAt: LocalDateTime) : this(
        null,
        keyword,
        total,
        pageNumber,
        isLast,
        searchAt
    )

}