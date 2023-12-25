package com.jaemin.exec.search.domain

import com.jaemin.exec.search.infrastructure.NaverHeaderFactory
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class NaverHeaderFactoryTest {

    @Autowired
    private lateinit var naverHeaderFactory: NaverHeaderFactory

    @Test
    fun createHeaderTest(){
        naverHeaderFactory.createHeader()
    }
}