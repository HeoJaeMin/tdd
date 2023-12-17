package com.jaemin.exec.search.domain.api.util

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApiRequestUtilTest {

    @Autowired
    private lateinit var  apiRequestUtil: ApiRequestUtil

    @Test
    fun setRequestParamsTest(){
        val text = "123"
        apiRequestUtil.setRequestParams(text, null);
    }
}