package com.dropbox.componentbox.samples.discovery.box

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.build
import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.samples.discovery.Inflate

@Composable
fun Component.Box.Inflate() {
    val components = this.components
    Box(modifier = this.modifier.build()) {
        components?.forEach { component ->
            component.Inflate()
        }
    }
}