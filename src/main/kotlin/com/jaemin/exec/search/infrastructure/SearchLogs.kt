package com.jaemin.exec.search.infrastructure

import jakarta.persistence.*

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
) {
    constructor(keyword: String, total: Int, pageNumber: Int, isLast: String) : this(
        null,
        keyword,
        total,
        pageNumber,
        isLast
    )

}