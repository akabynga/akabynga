package com.akabynga.kotlin.coursera.week2

import java.time.LocalDate

data class MyDate(val date: LocalDate) : Comparable<MyDate> {

    override fun compareTo(other: MyDate): Int {
        TODO("Not yet implemented")
    }

}