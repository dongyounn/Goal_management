package com.work.management.global.dto

import java.util.*
import kotlin.collections.ArrayList

fun Long.getAutoNumber(): List<Long> = this.randomUtils(ArrayList())

fun Long.randomUtils(list: MutableList<Long>?): List<Long> {
    val resultList = list ?: ArrayList()
    val random = Random()
    for (i in 0 until this) {
        var number: Long
        do {
            number = random.nextInt(45).toLong()
        } while (resultList.contains(number) || number == 0L)
        resultList.add(number)
    }
    return resultList.sorted()
}