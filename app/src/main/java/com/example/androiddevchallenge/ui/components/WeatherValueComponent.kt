package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.marsLight

@Composable
fun WeatherValueComponent(label: String, value: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(
            text = value,
            style = MaterialTheme.typography.h3
        )
        Text(
            text = label,
            style = MaterialTheme.typography.subtitle1,
            color = marsLight
        )
    }
}

@Preview
@Composable
fun PreviewWeatherValue() {
    WeatherValueComponent(label = "Label", value = "value")
}