package com.example.androiddevchallenge.domain.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate() : Date {
    val format = "yyyy-MM-dd"
    return SimpleDateFormat(format, Locale.getDefault()).parse(this)!!
}