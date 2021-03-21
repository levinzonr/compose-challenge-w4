package com.example.androiddevchallenge.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Circle() {
    val transformation = rememberInfiniteTransition()
    val spec=  infiniteRepeatable<Float>(
            animation = keyframes {
                durationMillis = 6000
            },
            repeatMode = RepeatMode.Restart
        )


    val degree = transformation.animateFloat(initialValue = 0f, targetValue = 360f, animationSpec = spec)
    Canvas(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        rotate(degree.value) {
            val path = PathEffect.dashPathEffect(floatArrayOf(size.width / 2, size.width / 4), 3f)
            drawCircle(
                color = Color.White,
                style = Stroke(
                    width = 3f,
                    pathEffect = path
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewCircle() {
    Circle()
}