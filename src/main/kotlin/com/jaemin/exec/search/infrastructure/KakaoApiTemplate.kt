package com.jaemin.exec.search.infrastructure

import com.jaemin.exec.core.util.ApiRequestUtil
import com.jaemin.exec.search.domain.ApiTemplate
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.net.URI

@Component
class KakaoApiTemplate<T>(
    private val kakaoTemplateFactory: KakaoTemplateFactory,
    private val apiRequestUtil: ApiRequestUtil
) : ApiTemplate<T> {
    override fun get(uri: String, params: Map<String, String>?, clazz: Class<T>): ResponseEntity<T> {
        val requestUri = apiRequestUtil.setRequestParams(uri, params)

        return kakaoTemplateFactory.getRestTemplate().getForEntity(requestUri, clazz)
    }

    override fun post(uri: String, body: Any?, clazz: Class<T>): ResponseEntity<T> {
        val requestUri: URI = URI.create(uri)
        return kakaoTemplateFactory.getRestTemplate().postForEntity(requestUri, body, clazz)
    }
}