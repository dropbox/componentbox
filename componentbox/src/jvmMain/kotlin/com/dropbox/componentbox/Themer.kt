package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.models.Color
import androidx.compose.ui.graphics.Color as ComposeColor

actual abstract class Themer {
    @Composable
    actual abstract fun Theme(isNightMode: Boolean, content: @Composable () -> Unit)

    @Composable
    abstract fun toMaterialTheme(color: Color): ComposeColor
}