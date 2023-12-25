package com.jaemin.exec.search.domain

import org.springframework.http.client.ClientHttpRequestInterceptor


//헤더 설정 --> return restTemplate
//리퀘스트 URL 설정
//리퀘스트 Method 설정
interface ClientHeaderFactory {

    fun createHeader(): List<ClientHttpRequestInterceptor>
}