package com.akabynga.kotlin.coursera.week2

import com.akabynga.kotlin.coursera.week1.Color

fun getDescription(color: Color): String =
    when (color) {
        Color.RED -> "red"
        Color.ORANGE -> "mild"
        Color.BLUE -> "cold"
        else -> ""
    }

fun print(color: Color) = println(getDescription(Color.RED))

fun respondToInput(input: String) = when (input) {
    "y", "yes" -> "I'm glad you agree"
    "n", "no" -> "Sorry to hear that"
    else -> "I don't understand you"
}

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

fun say(pet: Animal) =
    when (pet) {
        is Cat -> pet.meow()
        is Dog -> pet.woof()
        else -> throw Exception("Unsupported animal")
    }

fun getMyFavoritePet() = Cat()

fun main() {
    println(Color.RED)

    println(respondToInput("n"))
    try {
        println(mix(Color.RED, Color.BLUE))
    } catch (e: Exception) {
        println(e)
    }
    println(say(Cat()))

    println(say(getMyFavoritePet()))

}