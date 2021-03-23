package com.example.androiddevchallenge.domain

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.ui.graphics.ImageBitmap
import androidx.core.net.toUri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.withContext
import java.io.File
import java.io.InputStream

object ImageProvider {

    fun init(context: Context) {
        val dir = context.filesDir
        context.assets.list("mars")?.forEach {
            val name = it.split("-").first()
            val frameFile = File(dir, name)
            if (!frameFile.exists()) {
                frameFile.createNewFile()
                frameFile.writeBytes(context.assets.open("mars/$it").readBytes())
            }
        }
    }

    fun getFrame(context: Context, number: Int) : Uri? {
        val name = "frame_${if (number < 10) "0$number" else number.toString()}_delay"
        return context.filesDir.listFiles()?.find { it.name == name }?.toUri()
    }
}