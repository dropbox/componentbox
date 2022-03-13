package com.dropbox.componentbox.util

import com.dropbox.componentbox.foundation.ContentScale
import androidx.compose.ui.layout.ContentScale as ComposeContentScale

// This module targets JS
// Until material and foundation are supported on JS
// Changes to this file should be duplicated in androidMain
// TODO(https://github.com/dropbox/componentbox/issues/25)

fun ContentScale?.translate(): ComposeContentScale = when (this) {
    ContentScale.Crop -> ComposeContentScale.Crop
    ContentScale.Fit -> ComposeContentScale.Fit
    ContentScale.FillHeight -> ComposeContentScale.FillHeight
    ContentScale.FillWidth -> ComposeContentScale.FillWidth
    ContentScale.Inside -> ComposeContentScale.Inside
    ContentScale.None -> ComposeContentScale.None
    ContentScale.FillBounds -> ComposeContentScale.FillBounds
    null -> ComposeContentScale.None
}