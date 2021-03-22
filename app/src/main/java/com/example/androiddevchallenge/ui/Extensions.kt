package com.example.androiddevchallenge.ui

import androidx.compose.runtime.Composable


@Composable fun Int.toDegreesString() : String {
    return "$this °C"
}

@Composable fun Int.toSolString() : String {
    return "SOL $this"
}