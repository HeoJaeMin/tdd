package com.jaemin.exec.search.domain.api.template.impl

import com.jaemin.exec.search.domain.api.factory.template.impl.NaverTemplateFactory
import com.jaemin.exec.search.domain.api.util.ApiRequestUtil
import com.jaemin.exec.search.domain.api.template.ApiTemplate
import org.springframework.http.ResponseEntity
import java.net.URI

class NaverApiTemplate<T>(
    private val naverTemplateFactory: NaverTemplateFactory,
    private val apiRequestUtil: ApiRequestUtil
): ApiTemplate<T> {
    override fun get(uri: String, params: Map<String, String>?, clazz: Class<T>): ResponseEntity<T> {
        val requestUri: URI = apiRequestUtil.setRequestParams(uri, params)
        return naverTemplateFactory.getRestTemplate().getForEntity(requestUri, clazz)
    }

    override fun post(uri: String, body: Any?, clazz: Class<T>): ResponseEntity<T> {
        val requestUri: URI = URI.create(uri)
        return naverTemplateFactory.getRestTemplate().postForEntity(requestUri, body, clazz)
    }
}