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

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.screens.home.components.SolMenuComponent
import com.example.androiddevchallenge.ui.screens.home.components.SolPage
import com.example.androiddevchallenge.ui.screens.home.pages.ForecastPage
import com.example.androiddevchallenge.ui.screens.home.pages.LatestSolPage
import com.example.androiddevchallenge.ui.screens.home.pages.PreviousSolPage

@Composable
fun SolScreen(viewModel: SolViewModel) {
    val state = viewModel.viewState.observeAsState()
    Scaffold(
        topBar = {
            SolMenuComponent(
                items = state.value?.sols ?: listOf(),
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .padding(horizontal = 8.dp),
                current = state.value?.selectedSol,
                onSolNumberSelected = {
                    viewModel.onSolNumberSelected(it)
                }
            )
        }
    ) {
        state.value?.selectedSol?.let { sol ->
            when {
                sol is SolPage.Forecast -> {
                    ForecastPage(viewModel.viewState.value?.forecast ?: listOf())
                }
                sol is SolPage.SolHeader && sol.sol == state.value?.latestSol -> {
                    LatestSolPage(sol = sol.sol)
                }
                sol is SolPage.SolHeader -> {
                    PreviousSolPage(sol = sol.sol)
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewSolScreen() {
    SolScreen(viewModel = viewModel())
}
