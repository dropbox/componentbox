package com.dropbox.componentbox.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

actual abstract class Themer {
    @Composable
    abstract fun Theme(isNightMode: Boolean, content: @Composable () -> Unit)

    @Composable
    abstract fun getDrawableResPath(name: String?): String?

    @Composable
    abstract fun getTextStyle(name: String?): TextStyle?
}