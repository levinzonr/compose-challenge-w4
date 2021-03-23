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
package com.example.androiddevchallenge.domain

import android.content.Context
import android.net.Uri
import androidx.core.net.toUri
import java.io.File

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

    fun getFrame(context: Context, number: Int): Uri? {
        val name = "frame_${if (number < 10) "0$number" else number.toString()}_delay"
        return context.filesDir.listFiles()?.find { it.name == name }?.toUri()
    }
}
