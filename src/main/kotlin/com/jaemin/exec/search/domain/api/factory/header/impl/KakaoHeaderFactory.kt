package com.jaemin.exec.search.domain.api.factory.header.impl

import com.jaemin.exec.search.domain.api.factory.header.ClientHeaderFactory
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor
import org.springframework.http.HttpHeaders
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.stereotype.Component

@Component
class KakaoHeaderFactory : ClientHeaderFactory {

    companion object {
        const val AUTHORIZATION_KEY = HttpHeaders.AUTHORIZATION
        const val AUTHORIZATION_VALUE = "KakaoAK f4ec023718bc5ed2adad388e02f9238c"

    }

    override fun createHeader(): List<ClientHttpRequestInterceptor> {
        val interceptors = ArrayList<ClientHttpRequestInterceptor>()

        val headerParams = HashMap<String, String>()

        headerParams[AUTHORIZATION_KEY] = AUTHORIZATION_VALUE

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