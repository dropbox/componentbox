package com.dropbox.componentbox.samples.discovery.button

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.models.Component

@Composable
fun Component.Button.Inflate() {
    when (this.variant.buttonVariant()) {
        else -> contained(this)
    }
}
