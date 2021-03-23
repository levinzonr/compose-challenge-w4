package com.example.androiddevchallenge.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.components.MarsGlobeComponent
import com.example.androiddevchallenge.ui.screens.home.components.SolMenuComponent
import com.example.androiddevchallenge.ui.screens.home.components.SolSunsetSunrise
import com.example.androiddevchallenge.ui.screens.home.components.SolTemperature

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


    }
}


@Preview
@Composable
fun PreviewSolScreen() {
    SolScreen(viewModel = viewModel())
}