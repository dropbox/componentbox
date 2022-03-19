package com.dropbox.componentbox.samples.discovery.vector

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.samples.discovery.color.color
import com.dropbox.componentbox.samples.discovery.color.discoveryColor

@Composable
actual fun Component.Vector.Inflate() {
    val resourcePath = name.iconRes().resPath
    Icon(
        painter = painterResource(resourcePath),
        null,
        modifier = modifier.build(),
        tint = modifier?.background.discoveryColor().color()
    )
}