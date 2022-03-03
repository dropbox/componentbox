package com.dropbox.componentbox

import androidx.compose.runtime.Composable

expect abstract class Themer {
    @Composable
    abstract fun Theme(isNightMode: Boolean, content: @Composable () -> Unit)
}