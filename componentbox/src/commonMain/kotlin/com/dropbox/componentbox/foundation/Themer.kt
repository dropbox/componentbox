package com.dropbox.componentbox.foundation

import androidx.compose.runtime.Composable

expect abstract class Themer {
    @Composable
    abstract fun Theme(isNightMode: Boolean, content: @Composable () -> Unit)
}