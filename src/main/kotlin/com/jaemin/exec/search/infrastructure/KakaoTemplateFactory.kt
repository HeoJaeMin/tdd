package com.jaemin.exec.search.infrastructure

import com.jaemin.exec.search.domain.ClientTemplateFactory
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Component
class KakaoTemplateFactory(
    private val kakaoHeaderFactory: KakaoHeaderFactory
) : ClientTemplateFactory {
    override fun getRestTemplate(): RestTemplate {
        val restTemplateBuilder = RestTemplateBuilder()

        return restTemplateBuilder
            .setConnectTimeout(Duration.ofMillis(5000))
            .additionalInterceptors(kakaoHeaderFactory.createHeader())
            .setReadTimeout(Duration.ofMillis(5000))
            .build()
    }
}