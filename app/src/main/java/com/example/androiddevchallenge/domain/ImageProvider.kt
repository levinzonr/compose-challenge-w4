package com.example.androiddevchallenge.domain

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.withContext
import java.io.InputStream

object ImageProvider {
    suspend fun getFrame(context: Context, number: Int) : Bitmap? {
        val number = if (number < 10) "0$number" else number.toString()
        val name = "frame_${number}_delay"
        val assetName = withContext(Dispatchers.IO) { context.assets.list("mars") }?.find { it.startsWith(name) } ?: return null
        val inputStream = context.assets.open("mars/$assetName")
        ImageBitmap
        return BitmapFactory.decodeStream(inputStream)
    }
}