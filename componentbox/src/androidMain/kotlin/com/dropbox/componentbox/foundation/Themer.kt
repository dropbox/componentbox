package com.dropbox.componentbox.foundation

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

actual abstract class Themer {
    @Composable
    actual abstract fun Theme(isNightMode: Boolean, content: @Composable () -> Unit)

    abstract fun toColor(name: String?): Color

    @Composable
    @DrawableRes
    abstract fun getDrawableResId(name: String?): Int?

    @Composable
    @ColorRes
    abstract fun getColorResId(name: String?): Int?

    @Composable
    abstract fun getTextStyle(name: String?): TextStyle
}