package com.jaemin.exec.search.domain.api.util

import org.springframework.stereotype.Component
import org.yaml.snakeyaml.util.UriEncoder
import java.net.URI

@Component
class ApiRequestUtil{

    fun setRequestParams(url: String, requestParams: Map<String, String>?): URI {

        var result = url

        if (requestParams != null) {
            for (a in requestParams.entries) {
                val requestParam = "${a.key}=${UriEncoder.encode(a.value)}"

                if (result.contains("?")) {
                    result = result.plus("&")
                } else {
                    result = result.plus("?")
                }
                result = result.plus(requestParam)
            }
        }
        return URI.create(result)
    }
}