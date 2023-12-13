package com.jaemin.exec.search.infrastructure.api.factory

import org.springframework.http.HttpHeaders

interface ApiFactory {

    fun setAuth(): HttpHeaders

    fun setRequestParams(url: String, requestParams: Map<String, String>): String {
        for (a in requestParams.entries) {
            val requestParam = "${a.key}=${a.value}"

            if (url.contains("?")) {
                url.plus("&")
            } else {
                url.plus("?")
            }
            url.plus(requestParam)
        }
        return url
    }
}