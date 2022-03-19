package com.dropbox.componentbox.samples.discovery.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.samples.discovery.color.standardText
import com.dropbox.componentbox.samples.discovery.type.textStyle
import com.dropbox.componentbox.util.compose

@Composable
actual fun Component.Text.Inflate() {
    Text(
        text = this.text.toString(),
        style = this.textStyle.textStyle().textStyle(),
        modifier = this.modifier.build(),
        color = this.color.compose() ?: MaterialTheme.colors.standardText
    )
}