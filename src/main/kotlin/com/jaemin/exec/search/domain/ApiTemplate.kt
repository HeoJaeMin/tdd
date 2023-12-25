package com.jaemin.exec.search.domain

import org.springframework.http.ResponseEntity

interface ApiTemplate<T> {
    fun get(uri: String, params: Map<String, String>?, clazz: Class<T>): ResponseEntity<T>
    fun post(uri: String, body: Any?, clazz: Class<T>): ResponseEntity<T>
}