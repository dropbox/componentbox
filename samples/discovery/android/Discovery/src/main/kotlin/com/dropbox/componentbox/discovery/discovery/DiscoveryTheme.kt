package com.dropbox.componentbox.discovery.discovery

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dropbox.componentbox.discovery.discovery.scoping.appScope
import com.dropbox.componentbox.samples.discovery.color.Colors
import com.dropbox.componentbox.samples.discovery.type.materialTheme

@Composable
fun DiscoveryTheme(isNightMode: Boolean, content: @Composable () -> Unit) {
    val colors = remember { mutableStateOf(if (isNightMode) Colors.Dark else Colors.Light) }
    return MaterialTheme(
        typography = appScope().resourceProvider.typography().materialTheme(),
        colors = colors.value,
        content = content
    )
}