package com.example.androiddevchallenge.domain.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate() : Date {
    val format = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    return SimpleDateFormat(format, Locale.getDefault()).parse(this)!!
}