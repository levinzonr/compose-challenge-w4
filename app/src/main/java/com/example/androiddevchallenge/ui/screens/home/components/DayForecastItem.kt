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
package com.example.androiddevchallenge.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.domain.extensions.format
import com.example.androiddevchallenge.domain.models.DayForecast
import com.example.androiddevchallenge.ui.toDegreesString
import com.example.androiddevchallenge.ui.toSolString

@Composable
fun DayForecastItem(dayForecast: DayForecast, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = dayForecast.number.toSolString(),
                style = MaterialTheme.typography.h1.copy(fontSize = 16.sp)
            )
            Text(
                text = dayForecast.date.format(),
                style = MaterialTheme.typography.caption
            )
        }

        Row(horizontalArrangement = Arrangement.End) {
            Column {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = dayForecast.temperature.maxCelsius.toDegreesString(),
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.End
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = dayForecast.temperature.minCelsius.toDegreesString(),
                    style = MaterialTheme.typography.h3.copy(fontSize = 22.sp),
                    color = MaterialTheme.colors.secondary,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}
