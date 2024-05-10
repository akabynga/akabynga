package com.akabynga.kotlin.coursera.week2

fun sum(list: List<Int>): Int {
    var result = 0
    for (i in list) {
        result += i
    }
    return result
}

fun ArrayList<Int>.sum(): Int {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}

fun main(args: Array<String>) {
    println(listOf(1, 2, 3).sum())    // 6
}