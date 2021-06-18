package com.mateuszjanczak.efgs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmailFormsGatewayServerApplication

fun main(args: Array<String>) {
    runApplication<EmailFormsGatewayServerApplication>(*args)
}
