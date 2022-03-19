package com.dropbox.componentbox.material.surface

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.material.Inflate
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.util.translate

@Composable
fun Component.Surface.Inflate(context: Context?) {
    val isDark = isSystemInDarkTheme() || !MaterialTheme.colors.isLight

    val color = if (this.color?.dark != null && this.color?.light != null) {
        if (isDark) Color(this.color!!.dark) else Color(this.color!!.light)
    } else {
        MaterialTheme.colors.surface
    }

    val contentColor = if (this.contentColor?.dark != null && this.contentColor?.light != null) {
        if (isDark) Color(this.contentColor!!.dark) else Color(this.contentColor!!.light)
    } else {
        MaterialTheme.colors.onSurface
    }

    val shape = this.shape.translate()
    val elevation = this.elevation?.dp ?: 0.dp

    Surface(
        modifier = modifier.build(),
        shape = shape,
        color = color,
        contentColor = contentColor,
        elevation = elevation
    ) {
        components?.forEach { component ->
            component.Inflate(context)
        }
    }
}