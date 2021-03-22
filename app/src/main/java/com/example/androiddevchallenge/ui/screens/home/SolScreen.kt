package com.example.androiddevchallenge.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.repository.SolRepository
import com.example.androiddevchallenge.ui.components.MarsGlobeComponent
import com.example.androiddevchallenge.ui.screens.home.components.SolMenuComponent
import com.example.androiddevchallenge.ui.screens.home.components.SolSunsetSunrise
import com.example.androiddevchallenge.ui.screens.SolTemperature

@Composable
fun SolScreen() {
    val items = List(10) { "SOL 4541$it" }
    Scaffold(
        topBar = {
            SolMenuComponent(
                items = items,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .padding(horizontal = 8.dp)
            )
        }
    ) {
        val sol = SolRepository.getLatestSol()

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


@Preview
@Composable
fun PreviewSolScreen() {

}