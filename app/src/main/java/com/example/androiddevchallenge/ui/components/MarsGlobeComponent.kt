package com.example.androiddevchallenge.ui.components

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.domain.ImageProvider
import com.example.androiddevchallenge.ui.animations.rotationAnimation
import com.google.accompanist.glide.GlideImage


@Composable
fun MarsGlobeComponent(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val infiniteTransition = rememberInfiniteTransition()
    val frame by infiniteTransition.rotationAnimation(targetValue = 96f)
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        ImageProvider.getFrame(context, frame.toInt())?.let {
            GlideImage(
                data = it,
                contentDescription = "frame",
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
        }
        AnimatedDashedCircle(modifier = Modifier.fillMaxSize(0.8f))
    }
}

@Preview
@Composable
fun PreviewMarsGlobeComponent() {
    MarsGlobeComponent()
}