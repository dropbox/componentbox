package com.dropbox.componentbox.samples.discovery.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.build
import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.samples.discovery.color.color
import com.dropbox.componentbox.samples.discovery.color.discoveryColor
import com.dropbox.componentbox.samples.discovery.type.textStyle

@Composable
actual fun Component.Text.Inflate() {
    Text(
        text = this.text.toString(),
        style = this.textStyle.textStyle().textStyle(),
        modifier = this.modifier.build(),
        color = this.color.discoveryColor().color()
    )
}