package com.svp.infrastructure.common

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ColorFilter
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.Drawable

import java.io.InputStream

/**
 * Created by Pasha on 10/19/2015.
 */
object DrawableEx {
    fun getGray(context: Context, resource: Int): Drawable {
        val ico = context.resources.getDrawable(resource)
        ico.alpha = 100
        return ico
    }

    fun changeColor(drawable: Drawable, colorInt: Int) {
        val red = (colorInt and 0xFF0000) / 0xFFFF
        val green = (colorInt and 0xFF00) / 0xFF
        val blue = colorInt and 0xFF

        val matrix = floatArrayOf(0f, 0f, 0f, 0f, red.toFloat(), 0f, 0f, 0f, 0f, green.toFloat(), 0f, 0f, 0f, 0f, blue.toFloat(), 0f, 0f, 0f, 1f, 0f)

        val colorFilter = ColorMatrixColorFilter(matrix)
        drawable.colorFilter = colorFilter
    }

    fun getBitmapFromDrawableRes(context: Context, resId: Int): Bitmap {
        val `is` = context.resources.openRawResource(resId)
        return BitmapFactory.decodeStream(`is`)
    }
}
