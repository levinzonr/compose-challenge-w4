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
package com.example.androiddevchallenge.ui.screens.home.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.models.Sol
import com.example.androiddevchallenge.ui.components.WeatherValueComponent
import com.example.androiddevchallenge.ui.screens.home.components.SolCurrentTemperatureComponent
import com.example.androiddevchallenge.ui.toKmHString
import com.example.androiddevchallenge.ui.toPressureString

@Composable
fun LatestSolPage(sol: Sol) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = stringResource(id = R.string.header), style = MaterialTheme.typography.h1)
        Spacer(modifier = Modifier.height(32.dp))
        SolCurrentTemperatureComponent(sol = sol)
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            WeatherValueComponent(
                value = sol.pressure.value.toPressureString(),
                label = stringResource(id = R.string.pressure)
            )
            WeatherValueComponent(
                value = sol.windSpeedKmh.toKmHString(),
                label = stringResource(id = R.string.wind_speed)
            )
        }
    }
}
