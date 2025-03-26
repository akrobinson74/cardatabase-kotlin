package com.packt.cardatabase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CardatabaseApplication

fun main(args: Array<String>) {
	runApplication<CardatabaseApplication>(*args)
}
