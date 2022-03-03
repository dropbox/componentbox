package com.dropbox.componentbox.util

import com.dropbox.componentbox.models.Alignment
import com.dropbox.componentbox.models.Arrangement
import com.dropbox.componentbox.models.Image
import com.dropbox.componentbox.models.MultiplatformRes
import com.dropbox.componentbox.models.TextStyle

internal fun <T> T.name(): String {
    return when (this) {
        is TextStyle -> this.name
        is Image -> this.name
        is MultiplatformRes -> this.name
        is Alignment -> this.name
        is Arrangement -> this.name
        else -> ""
    }
}