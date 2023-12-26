package com.jaemin.exec.search.infrastructure

data class SearchLogsInfo(
    val logs: SearchLogs,
    val detail: List<SearchLogsDetail>,
)