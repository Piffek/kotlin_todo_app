package com.piffek.todoapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppKotlinApplication

fun main(args: Array<String>) {
    runApplication<AppKotlinApplication>(*args)
}
