package com.jaemin.exec.core.config

import io.github.resilience4j.circuitbreaker.CircuitBreaker
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CircuitBreakerConfig {

    @Bean
    fun config(): CircuitBreaker{
        return CircuitBreaker.ofDefaults("search");
    }
}