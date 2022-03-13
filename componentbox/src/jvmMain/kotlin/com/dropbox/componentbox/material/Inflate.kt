package com.dropbox.componentbox.material

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.material.box.Inflate
import com.dropbox.componentbox.material.button.Inflate
import com.dropbox.componentbox.material.column.Inflate
import com.dropbox.componentbox.material.drawable.Inflate
import com.dropbox.componentbox.material.row.Inflate
import com.dropbox.componentbox.material.text.Inflate

// This module targets JS
// Until material and foundation are supported on JS
// Changes to this file should be duplicated in androidMain
// TODO(https://github.com/dropbox/componentbox/issues/25)

@Composable
actual fun Component.Inflate(context: Context?) {
    when (this) {
        is Component.Box -> Inflate(context)
        is Component.Button -> Inflate(context)
        is Component.Column -> Inflate(context)
        is Component.Drawable -> Inflate(context)
        is Component.Row -> Inflate(context)
        is Component.Switch -> TODO()
        is Component.Text -> Inflate(context)
        is Component.Vector -> TODO()
        is Component.Surface -> Inflate(context)
    }
}