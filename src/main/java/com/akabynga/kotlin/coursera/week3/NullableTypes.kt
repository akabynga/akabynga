package com.akabynga.kotlin.coursera.week3

fun main() {
    var s1: String = "always not null"
    var s2: String? = null
    var s3: String? = "eqwe"
//    var s3: String = null not possible
    println(s1)
    println(s2)
//    println(s3.length)
    val s: String? = null
    println(s!!.length)
    if(s == null) return
    s.length
}