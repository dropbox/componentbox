package com.dropbox.componentbox.material.box

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.material.Inflate
import com.dropbox.componentbox.util.build

// This module targets JS
// Until material and foundation are supported on JS
// Changes to this file should be duplicated in androidMain
// TODO(https://github.com/dropbox/componentbox/issues/25)

@Composable
fun Component.Box.Inflate(context: Context?) {
    Box(modifier = modifier.build()) {
        components?.forEach { component ->
            component.Inflate(context)
        }
    }
}