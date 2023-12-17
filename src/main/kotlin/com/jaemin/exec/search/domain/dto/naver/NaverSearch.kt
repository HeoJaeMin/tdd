package com.jaemin.exec.search.domain.dto.naver

import com.jaemin.exec.search.presentation.dto.SearchResponse
import com.jaemin.exec.search.presentation.dto.SearchResponseDetail
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList
import kotlin.reflect.KFunction1

data class NaverSearch(
    val total: Int?,
    val start: Int?,
    val display: Int?,
    val items: MutableList<NaverSearchItems>?,
    val errorMessage: String?
){
    fun toSearchResponse(): SearchResponse
    {

        val content =  ArrayList<SearchResponseDetail>()

        for(a in items!!){
            content.add(
                a.toSearchResponseDetail()
            )
        }

        return SearchResponse(
            total = total,
            pageNumber = start,
            pageSize = display,
            isLast = if(!Objects.isNull(display) && !Objects.isNull(total)) display!!.div(total!!)+1==start else true,
            content = content
        )
    }
}