package com.akabynga.kotlin.coursera.week2

import java.io.IOException
import kotlin.jvm.Throws


fun checkNumber(number: Number): Boolean {
    if (number in 0..100) {
        return true
    } else {
        throw IllegalArgumentException("A percentage value must be between 0 and 100: $number")
    }
}

fun parseStringToNumber(string: String) {
    val number = try {
        Integer.parseInt(string)
    } catch (e: NumberFormatException) {
        null
    }
    println(number)
}

@Throws(IOException::class)
fun foo() {
    throw IOException()
}


fun main() {
    checkNumber(100)

    parseStringToNumber("4")
}