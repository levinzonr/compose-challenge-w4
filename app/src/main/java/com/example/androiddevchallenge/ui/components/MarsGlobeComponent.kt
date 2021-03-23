package com.example.androiddevchallenge.ui.components

import android.graphics.Bitmap
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.domain.ImageProvider


@Composable
fun MarsGlobeComponent(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val infiniteTransition = rememberInfiniteTransition()
    val frame by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 96f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 6000

            },
            repeatMode = RepeatMode.Restart
        )
    )

    Box(modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Box(modifier.fillMaxSize(0.98f)) {
            LoadableImage(frame.toString(), loader = {
                println("Loader invokd : ${frame.toInt()}")
                ImageProvider.getFrame(context, frame.toInt()) }
            )
        }
        AnimatedDashedCircle(modifier = Modifier.fillMaxSize(0.8f))

    }
}


@Composable
fun LoadableImage(key: String, modifier: Modifier = Modifier, loader: suspend () -> Bitmap?) {
    val state = remember { mutableStateOf<Bitmap?>(null) }
    LaunchedEffect(key1 = key, block = {
        val bitmap = loader.invoke()
        state.value = bitmap
    })
    println("Bitmap ${state.value}")
    state.value?.let {
        Image(
            bitmap= it.asImageBitmap(),
            contentDescription = "frame",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
    }
}

@Preview
@Composable
fun PreviewMarsGlobeComponent() {
    MarsGlobeComponent()
}