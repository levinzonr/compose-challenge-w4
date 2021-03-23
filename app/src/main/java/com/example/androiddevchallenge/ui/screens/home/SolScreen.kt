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
package com.example.androiddevchallenge.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.models.Sol
import com.example.androiddevchallenge.ui.components.MarsGlobeComponent
import com.example.androiddevchallenge.ui.components.WeatherValueComponent
import com.example.androiddevchallenge.ui.screens.home.components.SolCurrentTemperatureComponent
import com.example.androiddevchallenge.ui.screens.home.components.SolMenuComponent
import com.example.androiddevchallenge.ui.screens.home.components.SolSunsetSunrise
import com.example.androiddevchallenge.ui.screens.home.components.SolTemperature
import com.example.androiddevchallenge.ui.toKmHString
import com.example.androiddevchallenge.ui.toPressureString

@Composable
fun SolScreen(viewModel: SolViewModel) {
    val state = viewModel.viewState.observeAsState()
    Scaffold(
        topBar = {
            SolMenuComponent(
                items = state.value?.sols ?: listOf(),
                modifier = Modifier
                    .padding(top = 32.dp)
                    .padding(horizontal = 8.dp),
                current = state.value?.selectedSol,
                onSolNumberSelected = { viewModel.onSolNumberSelected(it) }
            )
        }
    ) {
        state.value?.selectedSol?.let { sol ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                if (sol == state.value?.latestSol) {
                    LatestSol(sol = sol)
                } else {
                    PreviousSol(sol = sol)
                }
            }
        }
    }
}

@Composable
private fun ColumnScope.LatestSol(sol: Sol) {
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

@Composable
private fun ColumnScope.PreviousSol(sol: Sol) {
    SolTemperature(
        sol = sol,
        modifier = Modifier.padding(horizontal = 32.dp)
    )
    MarsGlobeComponent(modifier = Modifier.fillMaxWidth(0.7f).aspectRatio(1f))
    SolSunsetSunrise(
        sol,
        modifier = Modifier.padding(horizontal = 32.dp)
    )
}

@Preview
@Composable
fun PreviewSolScreen() {
    SolScreen(viewModel = viewModel())
}
