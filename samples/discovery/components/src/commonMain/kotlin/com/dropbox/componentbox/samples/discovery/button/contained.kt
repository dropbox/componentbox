package com.dropbox.componentbox.samples.discovery.button

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.util.compose
import com.dropbox.componentbox.samples.discovery.Inflate
import com.dropbox.componentbox.samples.discovery.action

@Composable
fun contained(button: Component.Button) {
    Button(
        modifier = button.modifier.build(),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = button.modifier?.background.compose() ?: MaterialTheme.colors.primary,
        ),
        onClick = button.action.action().action().action()
    ) {
        button.components?.forEach { component ->
            component.Inflate()
        }
    }
}