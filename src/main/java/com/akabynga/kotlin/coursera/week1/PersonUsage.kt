package com.akabynga.kotlin.coursera.week1

import com.akabynga.kotlin.coursera.week1.Color.*
import java.util.*

fun main(vararg args: String) {
    val person = Person("Alice", 27)
    println(person)
    println(Arrays.toString(args))
}

fun updateWeather(degrees: Int) {
    val (description, color) = when {
        degrees < 10 -> "cold" to BLUE
        degrees < 25 -> "mild" to ORANGE
        else -> "hot" to RED
    }
}