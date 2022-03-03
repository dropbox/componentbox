package com.dropbox.componentbox.samples.discovery

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dropbox.componentbox.samples.discovery.color.Colors

@Composable
fun discoveryTheme(isNightMode: Boolean, content: @Composable () -> Unit) {
    val colors = remember { mutableStateOf(if (isNightMode) Colors.Dark else Colors.Light) }

    return MaterialTheme(
        colors = colors.value,
        content = content
    )
}