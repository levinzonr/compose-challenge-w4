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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.domain.models.Sol
import com.example.androiddevchallenge.domain.repository.SolRepository
import com.example.androiddevchallenge.ui.components.AnimatedDashedCircle
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.toDegreesString

@Composable
fun SolCurrentTemperatureComponent(sol: Sol, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .aspectRatio(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = 22.toDegreesString(),
                style = MaterialTheme.typography.h3.copy(fontSize = 86.sp)
            )
            Text(
                text = "Sunny",
                style = MaterialTheme.typography.subtitle1.copy(fontSize = 24.sp),
                color = MaterialTheme.colors.secondary
            )
        }
        AnimatedDashedCircle(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .aspectRatio(1f)
        )
    }
}

@Preview()
@Composable
fun PreviewSolComponent() {
    MyTheme {
        SolCurrentTemperatureComponent(SolRepository.getLatestSol())
    }
}
