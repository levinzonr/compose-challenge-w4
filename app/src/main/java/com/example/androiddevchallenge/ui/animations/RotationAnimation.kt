package com.example.androiddevchallenge.ui.animations

import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State


@Composable
fun InfiniteTransition.rotationAnimation(durationMs: Int = 6000, targetValue: Float) : State<Float> {
    val spec = infiniteRepeatable<Float>(
        animation = keyframes { durationMillis = 6000 },
        repeatMode = RepeatMode.Restart
    )
    return animateFloat(
        initialValue = 0f,
        targetValue = targetValue,
        animationSpec = spec
    )
}