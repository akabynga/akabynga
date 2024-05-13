package com.akabynga.kotlin.coursera.week3

fun main() {
    val x: Int? = 1
    val y: Int = 2

    val sum = x ?: 0 + y

    println(sum)
}