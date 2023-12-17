package com.jaemin.exec.search.domain.api.factory.template

import com.jaemin.exec.search.domain.api.factory.template.impl.NaverTemplateFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NaverTemplateFactoryTest {

    @Autowired
    private lateinit var naverTemplateFactory: NaverTemplateFactory

    @Test
    fun getRestTemplateTest(){
        naverTemplateFactory.getRestTemplate()
    }
}