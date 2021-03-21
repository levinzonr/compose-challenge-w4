package com.example.androiddevchallenge.domain.repository

import com.example.androiddevchallenge.domain.models.Pressure
import com.example.androiddevchallenge.domain.models.Sol
import com.example.androiddevchallenge.domain.models.SolTemperature
import com.example.androiddevchallenge.domain.extensions.toDate

object SolRepository {

    fun getLatestSol() : Sol {
        return SOL_LATEST
    }

     fun getSolByNumber(number: Int) : Sol? {
        return SOLS.find { it.number == number }
    }

    private val SOL_LATEST = Sol(
        number = 3061,
        date = "2021-03-17".toDate(),
        season = "Month 1",
        temperature = SolTemperature(-74, -13),
        pressure = Pressure(837, "Higher"),
        atmosphereOpacity = "Sunny",
        sunriseTime = "6:31",
        sunsetTime = "18:26"
    )

    private val SOLS = listOf(
        SOL_LATEST,
        Sol(
            number = 3060,
            date = "2021-03-16".toDate(),
            season = "Month 1",
            temperature = SolTemperature(-73, -14),
            pressure = Pressure(839, "Higher"),
            atmosphereOpacity = "Sunny",
            sunriseTime = "6:31",
            sunsetTime = "18:26"
        ),
        Sol(
            number = 3059,
            date = "2021-03-15".toDate(),
            season = "Month 1",
            temperature = SolTemperature(-77, -16),
            pressure = Pressure(836, "Higher"),
            atmosphereOpacity = "Sunny",
            sunriseTime = "6:32",
            sunsetTime = "18:27"
        ),
        Sol(
            number = 3058,
            date = "2021-03-14".toDate(),
            season = "Month 1",
            temperature = SolTemperature(-73, -15),
            pressure = Pressure(837, "Higher"),
            atmosphereOpacity = "Sunny",
            sunriseTime = "6:32",
            sunsetTime = "18:27"
        ),
        Sol(
            number = 3057,
            date = "2021-03-17".toDate(),
            season = "Month 1",
            temperature = SolTemperature(-73, -13),
            pressure = Pressure(837, "Higher"),
            atmosphereOpacity = "Sunny",
            sunriseTime = "6:31",
            sunsetTime = "18:26"
        )
    )
}