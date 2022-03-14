package com.dropbox.componentbox

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun com.dropbox.componentbox.foundation.Color?.compose(): Color? {
    if (this == null) return null
    return if (MaterialTheme.colors.isLight) Color(light) else Color(dark)
}