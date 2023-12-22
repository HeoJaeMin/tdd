package com.jaemin.exec.search.domain.api.factory.header.impl

import com.jaemin.exec.search.domain.api.factory.header.ClientHeaderFactory
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.stereotype.Component

@Component
class NaverHeaderFactory : ClientHeaderFactory {

    companion object {
        const val CLIENT_ID_KEY = "X-Naver-Client-Id"
        const val CLIENT_ID_VALUE = "yZl5YZH4Hzz9A1oGsCKl"
        const val CLIENT_SECRET_KEY = "X-Naver-Client-Secret"
        const val CLIENT_SECRET_VALUE = "cBeXFVmzlW"
    }

    override fun createHeader(): List<ClientHttpRequestInterceptor> {
        val interceptors = ArrayList<ClientHttpRequestInterceptor>()

        val headerParams = HashMap<String, String>()

        headerParams[CLIENT_ID_KEY] = CLIENT_ID_VALUE
        headerParams[CLIENT_SECRET_KEY] = CLIENT_SECRET_VALUE
        headerParams[HttpHeaders.ACCEPT] = MediaType.APPLICATION_JSON.toString()
        headerParams[HttpHeaders.CONTENT_TYPE] = MediaType.APPLICATION_JSON.toString()

        headerParams.entries.forEach {
            interceptors.add(
                HttpHeaderInterceptor(
                    it.key, it.value
                )
            )
        }

        return interceptors
    }
}