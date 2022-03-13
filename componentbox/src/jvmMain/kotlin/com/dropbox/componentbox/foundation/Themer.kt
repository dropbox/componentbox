package com.dropbox.componentbox.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

actual abstract class Themer {
    @Composable
    actual abstract fun Theme(isNightMode: Boolean, content: @Composable () -> Unit)

    @Composable
    abstract fun toColor(name: String?): androidx.compose.ui.graphics.Color

    @Composable
    abstract fun toMaterialTheme(color: Color): androidx.compose.ui.graphics.Color

    @Composable
    abstract fun getDrawableResPath(name: String?): String?

    @Composable
    abstract fun getTextStyle(name: String?): TextStyle?
}