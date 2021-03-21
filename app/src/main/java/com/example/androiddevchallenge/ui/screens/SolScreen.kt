package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.domain.repository.SolRepository
import com.example.androiddevchallenge.ui.components.MarsGlobeComponent
import com.example.androiddevchallenge.ui.components.SolTemperatureComponent
import com.google.accompanist.glide.GlideImage

@Composable
fun SolScreen() {
    Scaffold {
        val sol = SolRepository.getLatestSol()

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "SOL ${sol.number}", style = MaterialTheme.typography.h1)
            Spacer(modifier = Modifier.height(25.dp))
            MarsGlobeComponent(modifier = Modifier
                .fillMaxWidth(0.6f)
                .aspectRatio(1f))
            SolTemperatureComponent(temperature = sol.temperature)
        }

    }
}


@Preview
@Composable
fun PreviewSolScreen() {

}