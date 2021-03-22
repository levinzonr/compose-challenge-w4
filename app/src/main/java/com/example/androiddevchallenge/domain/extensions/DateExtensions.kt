package com.example.androiddevchallenge.domain.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate() : Date {
    val format = "yyyy-MM-dd"
    return SimpleDateFormat(format, Locale.getDefault()).parse(this)!!
}

fun Date.format() : String {
    val format = "MMM dd"
    return SimpleDateFormat(format, Locale.getDefault()).format(this)
}