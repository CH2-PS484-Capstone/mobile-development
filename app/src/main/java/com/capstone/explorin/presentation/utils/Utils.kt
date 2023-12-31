package com.capstone.explorin.presentation.utils

import android.content.Context
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream

fun getJsonAsString(context: Context, resId: Int): String {
    val inputStream = context.resources.openRawResource(resId)
    return readTextFile(inputStream)
}

fun readTextFile(inputStream: InputStream): String {
    val outputStream = ByteArrayOutputStream()
    val buf = ByteArray(1024)
    var len: Int

    try {
        while (inputStream.read(buf).also { len = it } != -1) {
            outputStream.write(buf, 0, len)
        }

        outputStream.close()
        inputStream.close()
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return outputStream.toString()
}