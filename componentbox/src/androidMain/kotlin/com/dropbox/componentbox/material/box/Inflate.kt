package com.dropbox.componentbox.material.box

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.material.Inflate
import com.dropbox.componentbox.util.build

@Composable
fun Component.Box.Inflate(context: Context?) {
    Box(modifier = modifier.build()) {
        components?.forEach { component ->
            component.Inflate(context)
        }
    }
}