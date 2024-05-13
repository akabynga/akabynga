package com.akabynga.kotlin.coursera.week3

fun String?.isEmptyOrNull() = this == null || this.isEmpty()

fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = ""
    val s3 = "   "

//    s1.isEmptyOrNull() eq true
//    s2.isEmptyOrNull() eq true
//    s3.isEmptyOrNull() eq false
}