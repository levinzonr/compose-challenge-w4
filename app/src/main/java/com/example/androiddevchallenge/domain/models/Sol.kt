package com.example.androiddevchallenge.domain.models

import java.util.*

data class Sol(
    val number: Int,
    val date: Date,
    val temperature: SolTemperature,
    val pressure: Pressure,
    val sunriseTime: String,
    val sunsetTime: String,
    val atmosphereOpacity: String,
    val season: String,
    val windSpeedKmh: Int = 0
)