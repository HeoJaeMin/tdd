package com.jaemin.exec.search.presentation

data class SearchRequest(
    val keyword: String,
    val sort: SearchSort,
    val page: Int,
    val display: Int
) {
    fun validate() {

        if (this.keyword.isEmpty()) throw RuntimeException("키워드가 없습니다.")
        if (page < 1) throw RuntimeException("페이지 번호가 알맞지 않습니다.")
        if (display > 100) throw RuntimeException("검색 크기가 너무 큽니다.")
        if (display <= 0) throw RuntimeException("검색 크기가 너무 작습니다.")
    }
}