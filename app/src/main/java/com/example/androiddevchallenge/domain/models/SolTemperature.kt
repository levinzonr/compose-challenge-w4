package com.example.androiddevchallenge.domain.models

data class SolTemperature(
    val minCelsius: Int,
    val maxCelsius: Int,
    val currentCelsius: Int = 0
)