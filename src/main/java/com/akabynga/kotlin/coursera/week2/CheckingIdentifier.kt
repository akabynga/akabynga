package com.akabynga.kotlin.coursera.week2

// Implement the function that checks whether a string is a valid identifier.
// A valid identifier is a non-empty string that starts with a letter or underscore and consists of only letters, digits and underscores.

fun isValidIdentifier(s: String): Boolean {
    fun isValidChar(c: Char): Boolean {
        return c in 'a'..'z' || c in 'A'..'Z' || c == '_'
    }

    fun isValidNumber(c: Char): Boolean {
        return c in '0'..'9'
    }
    if (s.isEmpty() || !(s[0] in 'a'..'z' || s[0] in 'A'..'Z' || s[0] == '_')) {
        return false
    }
    for (c in s) {
        if (!(isValidChar(c) || isValidNumber(c))) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}