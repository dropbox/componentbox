package com.dropbox.componentbox.util

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle

@Composable
inline fun <reified T> String?.translate(): T? = when (T::class) {
    TextStyle::class -> when (this) {
        "H1" -> MaterialTheme.typography.h1 as T
        "H2" -> MaterialTheme.typography.h2 as T
        "H3" -> MaterialTheme.typography.h3 as T
        "H4" -> MaterialTheme.typography.h4 as T
        "H5" -> MaterialTheme.typography.h5 as T
        "H6" -> MaterialTheme.typography.h6 as T
        "BODY1" -> MaterialTheme.typography.body1 as T
        "BODY2" -> MaterialTheme.typography.body2 as T
        "BUTTON" -> MaterialTheme.typography.button as T
        "CAPTION" -> MaterialTheme.typography.caption as T
        else -> MaterialTheme.typography.body2 as T
    }

    else -> null
}