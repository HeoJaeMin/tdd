package com.jaemin.exec

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExecApplication

fun main(args: Array<String>) {
	runApplication<ExecApplication>(*args)
}
