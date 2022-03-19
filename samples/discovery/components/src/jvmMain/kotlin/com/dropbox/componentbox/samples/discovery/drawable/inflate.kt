package com.dropbox.componentbox.samples.discovery.drawable

import androidx.compose.foundation.Image
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.foundation.Component

@Composable
actual fun Component.Drawable.Inflate() {
    val resourcePath = if (MaterialTheme.colors.isLight) name.image().light.resPath else name.image().dark.resPath
    Image(painter = painterResource(resourcePath), null, modifier = modifier.build())
}