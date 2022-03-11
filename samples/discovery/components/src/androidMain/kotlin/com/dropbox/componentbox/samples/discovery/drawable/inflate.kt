package com.dropbox.componentbox.samples.discovery.drawable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.dropbox.componentbox.foundation.Component

@Composable
actual fun Component.Drawable.Inflate() {
    Image(
        painter = painterResource(this.name.imageRes().resId),
        contentDescription = null
    )
}
