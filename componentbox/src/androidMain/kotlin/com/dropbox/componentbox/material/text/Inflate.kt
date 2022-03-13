package com.dropbox.componentbox.material.text

import androidx.annotation.DrawableRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.util.translate

// This module targets JS
// Until material and foundation are supported on JS
// Changes to this file should be duplicated in jvmMain
// TODO(https://github.com/dropbox/componentbox/issues/25)

@Composable
fun Component.Text.Inflate(context: Context?) {
    val style: TextStyle =
        context?.themer?.getTextStyle(textStyle) ?: textStyle.translate() ?: MaterialTheme.typography.body2

    @DrawableRes
    val colorResId = context?.themer?.getColorResId(modifier?.background)

    val color = if (colorResId != null) {
        Color(colorResId)
    } else {
        MaterialTheme.colors.onBackground
    }

    Text(
        text = text.toString(),
        style = style,
        modifier = this.modifier.build(),
        color = color
    )
}