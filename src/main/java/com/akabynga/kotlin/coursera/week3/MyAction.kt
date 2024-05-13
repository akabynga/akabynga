package com.akabynga.kotlin.coursera.week3

class MyAction {

    lateinit var list: CustomList
    fun isEnabled(): Boolean = list.selectedValue != null

    fun actionPerformed() {
        val value = list.selectedValue!!
    }

    class CustomList(var selectedValue: Number) {
    }
}
