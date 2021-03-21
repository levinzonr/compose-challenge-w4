package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.models.SolTemperature
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun SolTemperatureComponent(temperature: SolTemperature) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(R.string.temperature_max), style = MaterialTheme.typography.subtitle1)
            TemperatureComponent(value = temperature.maxCelsius)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(R.string.temperature_min), style = MaterialTheme.typography.subtitle1)
            TemperatureComponent(value = temperature.minCelsius)
        }
    }
}

@Composable
fun TemperatureComponent(value: Int) {
    Text(text = "$value °C", style = MaterialTheme.typography.h3)
}

@Preview
@Composable
fun PreviewTemperatureComponent() {
    MyTheme() {
        SolTemperatureComponent(temperature = SolTemperature(-23, -10))
    }
}