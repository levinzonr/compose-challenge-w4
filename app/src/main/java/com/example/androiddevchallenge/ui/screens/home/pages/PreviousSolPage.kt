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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.models.Sol
import com.example.androiddevchallenge.ui.components.MarsGlobeComponent
import com.example.androiddevchallenge.ui.screens.home.components.SolSunsetSunrise
import com.example.androiddevchallenge.ui.screens.home.components.SolTemperature

@Composable
fun PreviousSolPage(sol: Sol) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SolTemperature(
            sol = sol,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        MarsGlobeComponent(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .aspectRatio(1f)
        )
        SolSunsetSunrise(
            sol,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}
