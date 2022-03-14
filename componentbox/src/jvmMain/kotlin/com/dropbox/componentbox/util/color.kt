package com.dropbox.componentbox.util

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// This module targets JS
// Until material and foundation are supported on JS
// Changes to this file should be duplicated in androidMain
// TODO(https://github.com/dropbox/componentbox/issues/25)


@Composable
fun com.dropbox.componentbox.foundation.Color?.compose(): Color? {
    if (this == null) return null
    return if (MaterialTheme.colors.isLight) Color(light) else Color(dark)
}