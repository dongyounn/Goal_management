package com.exercise.crossfit

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CrossfitApplication

fun main(args: Array<String>) {
	runApplication<CrossfitApplication>(*args)
}
