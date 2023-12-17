package com.jaemin.exec.search.domain.api.factory.template

import org.springframework.web.client.RestTemplate

interface ClientTemplateFactory {

    fun getRestTemplate(): RestTemplate
}