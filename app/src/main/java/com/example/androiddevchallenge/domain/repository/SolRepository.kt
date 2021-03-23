/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.domain.repository

import com.example.androiddevchallenge.domain.extensions.toDate
import com.example.androiddevchallenge.domain.models.Pressure
import com.example.androiddevchallenge.domain.models.Sol
import com.example.androiddevchallenge.domain.models.SolTemperature
import java.util.Date

object SolRepository {

    fun getLatestSol(): Sol {
        return SOL_LATEST
    }

    fun getSolByNumber(number: Int): Sol? {
        return SOLS.find { it.number == number }
    }

    fun getAvailableSols(): List<Sol> = SOLS.sortedBy { it.number }

    private val SOL_LATEST = Sol(
        number = 3061,
        date = Date(),
        season = "Month 1",
        temperature = SolTemperature(-74, -13),
        pressure = Pressure(837, "Higher"),
        atmosphereOpacity = "Sunny",
        sunriseTime = "6:31",
        sunsetTime = "18:26",
        windSpeedKmh = 25
    )

    private val SOLS = listOf(
        SOL_LATEST,
        Sol(
            number = 3060,
            date = "2021-03-16".toDate(),
            season = "Month 1",
            temperature = SolTemperature(-73, -14, -54),
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
            date = "2021-03-13".toDate(),
            season = "Month 1",
            temperature = SolTemperature(-73, -13),
            pressure = Pressure(837, "Higher"),
            atmosphereOpacity = "Sunny",
            sunriseTime = "6:31",
            sunsetTime = "18:26"
        )
    )
}
