package com.dropbox.componentbox.material.button

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.ButtonVariant
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.util.translate

@Composable
fun Component.Button.Inflate(context: Context?) {
    when (this.variant.translate<ButtonVariant>()) {
        ButtonVariant.Contained -> Contained(context)
        ButtonVariant.Text -> TODO()
        ButtonVariant.Outlined -> TODO()
        ButtonVariant.Icon -> TODO()
    }
}