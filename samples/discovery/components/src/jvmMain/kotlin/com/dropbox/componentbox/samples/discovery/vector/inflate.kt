package com.dropbox.componentbox.samples.discovery.vector

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.util.compose

@Composable
actual fun Component.Vector.Inflate() {
    val resourcePath = name.iconRes().resPath
    Icon(
        painter = painterResource(resourcePath),
        null,
        modifier = modifier.build(),
        tint = modifier?.background.compose() ?: MaterialTheme.colors.onBackground
    )
}