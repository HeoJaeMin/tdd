package com.jaemin.exec.search.infrastructure.api.factory

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

open class NaverApiFactory : ApiFactory {

    companion object {
        const val CLIENT_ID_KEY = "X-Naver-Client-Id"
        const val CLIENT_ID_VALUE = "yZl5YZH4Hzz9A1oGsCKl"
        const val CLIENT_SECRET_KEY = "X-Naver-Client-Secret"
        const val CLIENT_SECRET_VALUE = "cBeXFVmzlW"
    }

    override fun setAuth(): HttpHeaders {
        val headers = HttpHeaders()

        headers.set(CLIENT_ID_KEY, CLIENT_ID_VALUE)
        headers.set(CLIENT_SECRET_KEY, CLIENT_SECRET_VALUE)
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())

        return headers
    }

    fun setHeader(): HttpEntity<Any> {
        return HttpEntity<Any>("parameters", setAuth())
    }
}