package com.dropbox.componentbox.samples.discovery.vector

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.dropbox.componentbox.util.compose
import com.dropbox.componentbox.foundation.Component

@Composable
actual fun Component.Vector.Inflate() {
    Icon(
        painter = painterResource(this.name.iconRes().resId),
        contentDescription = null,
        tint = this.color.compose() ?: this.modifier?.background.compose() ?: MaterialTheme.colors.onBackground
    )
}
