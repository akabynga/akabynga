@file:JvmName("Util")

package com.akabynga.kotlin.coursera.week2

fun main(args: Array<String>) {

    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    println("Hello $name");

    val int = mutableListOf("as", 1)
    int.add("r")
    println(int)

    val m = max(1, 2)
    println(m)
    displayMax(4, 0)

    println(listOf('a', 'b', 'c').joinToString("", "(", ")"))
    println(listOf('a', 'b', 'c').joinToString(",", "----"))

    displaySeparator('s', 10)
    displaySeparator(size = 1000)
    // displaySeparator(1, '4') not working
}

fun displaySeparator(character: Char = '*', size: Int = 10) {
    repeat(size) {
        print(character)
    }
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun displayMax(a: Int, b: Int) = println(max(a, b))

@JvmOverloads
fun sum(a: Int = 0, b: Int = 0, c: Int = 0) = a + b + c