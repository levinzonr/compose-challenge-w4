package com.example.androiddevchallenge.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
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
        AnimatedDashedCircle(modifier = Modifier
            .fillMaxWidth(0.8f)
            .aspectRatio(1f))
    }
}

@Preview()
@Composable
fun PreviewSolComponent() {
    MyTheme {
        SolCurrentTemperatureComponent(SolRepository.getLatestSol())
    }
}