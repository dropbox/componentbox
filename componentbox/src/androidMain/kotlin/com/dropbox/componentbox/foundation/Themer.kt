package com.dropbox.componentbox.foundation

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

actual abstract class Themer {
    @Composable
    abstract fun Theme(isNightMode: Boolean, content: @Composable () -> Unit)

    @Composable
    @DrawableRes
    abstract fun getDrawableResId(name: String?): Int?

    @Composable
    abstract fun getTextStyle(name: String?): TextStyle?
}