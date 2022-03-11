package com.dropbox.componentbox.util

import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Image
import com.dropbox.componentbox.foundation.MultiplatformRes
import com.dropbox.componentbox.foundation.TextStyle

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