package com.dropbox.componentbox.material

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.util.horizontal
import com.dropbox.componentbox.util.vertical

@Composable
expect fun Component.Inflate(context: Context?)

@Composable
fun ComponentBox.Inflate(context: Context) {
    when (this) {
        is ComponentBox.Banner ->
            Row(
                verticalAlignment = horizontalAlignment.vertical(),
                horizontalArrangement = verticalArrangement.horizontal()
            ) {
                components.forEach { component ->
                    context.inflater?.Inflate(component) ?: component.Inflate()
                }
            }

        is ComponentBox.Modal ->
            Column(
                horizontalAlignment = horizontalAlignment.horizontal(),
                verticalArrangement = verticalArrangement.vertical()
            ) {
                components.forEach { component ->
                    context.inflater?.Inflate(component) ?: component.Inflate()
                }
            }

        is ComponentBox.Screen ->
            Column(
                modifier = androidx.compose.ui.Modifier.fillMaxSize(),
                horizontalAlignment = horizontalAlignment.horizontal(),
                verticalArrangement = verticalArrangement.vertical()
            ) {
                components.forEach { component ->
                    context.inflater?.Inflate(component) ?: component.Inflate()
                }
            }
    }
}