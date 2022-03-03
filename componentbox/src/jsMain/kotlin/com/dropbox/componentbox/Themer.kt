package com.dropbox.componentbox

import androidx.compose.runtime.Composable

actual abstract class Themer {
    @Composable
    actual abstract fun Theme(isNightMode: Boolean, content: @Composable () -> Unit)
}