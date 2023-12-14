package com.jaemin.exec.search.infrastructure.api.factory

import org.springframework.http.HttpHeaders
import org.yaml.snakeyaml.util.UriEncoder

interface ApiFactory {

    fun setAuth(): HttpHeaders

    fun setRequestParams(url: String, requestParams: Map<String, String>): String {

        var result = url

        for (a in requestParams.entries) {
            val requestParam = "${a.key}=${UriEncoder.encode(a.value)}"

            if (result.contains("?")) {
                result = result.plus("&")
            } else {
                result = result.plus("?")
            }
            result = result.plus(requestParam)
        }
        return result
    }
}