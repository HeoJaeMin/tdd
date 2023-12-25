package com.jaemin.exec.search.domain

import org.springframework.web.client.RestTemplate

interface ClientTemplateFactory {

    fun getRestTemplate(): RestTemplate
}