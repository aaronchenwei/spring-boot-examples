package com.example.helloworldkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloWorldKotlinApplication

fun main(args: Array<String>) {
	runApplication<HelloWorldKotlinApplication>(*args)
}
