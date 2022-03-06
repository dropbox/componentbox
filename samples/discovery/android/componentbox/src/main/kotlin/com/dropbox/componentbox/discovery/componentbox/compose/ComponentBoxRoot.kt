package com.dropbox.componentbox.discovery.componentbox.compose

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.models.ComponentBox

@Composable
inline fun <reified C : ComponentBox> ComponentBoxRoot(
    modal: @Composable () -> Unit,
    screen: @Composable () -> Unit,
    banner: @Composable () -> Unit,
) = when (C::class) {
    ComponentBox.Modal::class -> modal()
    ComponentBox.Screen::class -> screen()
    ComponentBox.Banner::class -> banner()
    else -> {}
}