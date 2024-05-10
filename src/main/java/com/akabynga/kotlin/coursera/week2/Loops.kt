package com.akabynga.kotlin.coursera.week2

import java.time.LocalDate


fun loop() {
    println("Loop over map")
    val map = mapOf(1 to "One", 2 to "Two", 3 to "Three")

    for ((key, value) in map) {
        println("\$key:$key, \$value:$value ")
    }
}

fun loopWithIndex() {
    println("Loop over list with indexes")
    val list = listOf("a", "b", "c")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}

fun loopOverRange(start: Int = 0, end: Int = start + 10) {
    println("Loop over range")
    for (i in start..end) {
        println("$i")
    }
}

fun loopOverRangeExcludingLast(start: Int = 0, end: Int = start + 10) {
    println("Loop over range excluding last")
    for (i in start until end) {
        println("$i")
    }
}

fun loopDownToWithStep(start: Int = 0, end: Int = start - 10, step: Int = 2) {
    println("Loop down from $start to $end with step $step")
    for (i in start downTo end step step) {
        println("$i")
    }
}

fun loopOverString(s: String = "abc") {
    println("Loop over String")
    for (ch in s) {
        print(ch + 1)
    }
}

fun loopOverChars(start: Char = 'a', end: Char = 'z') {
    println("Loop over Chars")
    for (c in start..end) {
        print(c)
    }
    println()
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know..."
}

fun loopOverString(strings: List<String>) {
    println("Iterate over string list")
    for (s in strings) {
        println(s)
    }
}

val intRange: IntRange = 1..9
val anotherOntRange = 1 until 10
val charRange: CharRange = 'a'..'z'
val stringRange: ClosedRange<String> = "ab".."az"
val dateRange: ClosedRange<MyDate> = MyDate(LocalDate.now())..MyDate(LocalDate.now().plusDays(10))
fun main() {
    loop()

    loopWithIndex()

    loopOverRange()

    loopOverRangeExcludingLast()

    loopDownToWithStep(step = 1)

    loopOverString("Hello world!")

    loopOverChars()

    println("'q' is letter: ${isLetter('q')}")
    println("'*' is letter: ${isLetter('*')}")
    println("'x' is not digit: ${isNotDigit('x')}")
    println("\$ recognized as: ${recognize('$')}")
    println("'a' recognized as: ${recognize('a')}")
    println("'6' recognized as: ${recognize('6')}")

    loopOverString(listOf("string1", "string2"))

}