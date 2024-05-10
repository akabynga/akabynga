package com.akabynga.kotlin.coursera.week2.mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    var rightPosition = 0
    var wrongPosition = 0

    val charsSecret = secret.toCharArray()
    val charsGuess = guess.toCharArray()


    for ((index, value) in charsGuess.withIndex()) {
        if (value == charsSecret[index]) {
            rightPosition++
            charsSecret[index] = ' '
            charsGuess[index] = ' '
        }
    }

    for ((index, value) in charsGuess.withIndex()) {
        if (value == ' ') {
            continue
        }
        for (i in 0 until secret.length) {
            if (value == charsSecret[i]) {
                charsSecret[i] = ' '
                charsGuess[index] = ' '
                wrongPosition++
                break
            }
        }
    }

    return Evaluation(rightPosition, wrongPosition)
}