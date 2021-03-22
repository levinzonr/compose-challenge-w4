package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.models.Sol
import com.example.androiddevchallenge.domain.models.SolTemperature
import com.example.androiddevchallenge.ui.components.WeatherValueComponent

@Composable
fun SolTemperature(sol: Sol, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        WeatherValueComponent(
            label = stringResource(id = R.string.temperature_max),
            value = sol.temperature.maxCelsius.toString()
        )
        WeatherValueComponent(
            label = stringResource(id = R.string.temperature_min),
            value = sol.temperature.minCelsius.toString()
        )
    }
}