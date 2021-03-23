package com.example.androiddevchallenge.domain.extensions

fun<T> List<T>.nextAfter(item: T) : T? {
    val index = indexOf(item)
    return getOrNull(index.inc())
}

fun<T> List<T>.previousBefore(item: T) : T? {
    val index = indexOf(item)
    return getOrNull(index.dec())
}