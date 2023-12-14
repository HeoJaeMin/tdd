package com.jaemin.exec.search.infrastructure.api.factory

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

open class KakaoApiFactory : ApiFactory {

    companion object {
        const val REST_API_KEY = "f4ec023718bc5ed2adad388e02f9238c"
    }

    override fun setAuth(): HttpHeaders {
        val headers = HttpHeaders()

        headers.set(HttpHeaders.AUTHORIZATION, "KakaoAK $REST_API_KEY")
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON.toString())
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString())

        return headers
    }

    fun setHeader(): HttpEntity<Any> {
        return HttpEntity<Any>("parameters", setAuth())
    }
}