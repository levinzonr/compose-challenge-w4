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
package com.example.androiddevchallenge.ui.components

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
