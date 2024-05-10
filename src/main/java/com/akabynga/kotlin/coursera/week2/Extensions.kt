package com.akabynga.kotlin.coursera.week2

import javax.swing.JPopupMenu.Separator

fun String.repeat(n: Int): String {
    val sb = StringBuilder(n * length)
    for (i in 1..n) {
        sb.append(this)
    }
    return sb.toString()
}

fun collectionsPrint() {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(
        1 to "one", 7 to "seven", 53 to "fifty-three"
    )

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
}

fun joinExample() {
    println(listOf('a', 'b', 'c').joinToString(separator = "", prefix = "(", postfix = ")"))
}

fun String.get(index: Int) = '*'

fun main() {
    println("-".repeat(10))
    collectionsPrint()
    joinExample()

    println("abc".get(1))
}