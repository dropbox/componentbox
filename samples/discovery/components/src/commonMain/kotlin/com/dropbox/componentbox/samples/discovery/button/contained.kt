package com.dropbox.componentbox.samples.discovery.button

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.samples.discovery.Inflate
import com.dropbox.componentbox.samples.discovery.action
import com.dropbox.componentbox.samples.discovery.color.color
import com.dropbox.componentbox.samples.discovery.color.discoveryColor

@Composable
private fun Component.Button.backgroundColor(): Color {
    return if (this.modifier?.background != null) {
        this.modifier!!.background.discoveryColor().color()
    } else {
        MaterialTheme.colors.primary
    }
}

@Composable
private fun Component.Button.contentColor(): Color {
    return MaterialTheme.colors.onPrimary
}

@Composable
fun contained(button: Component.Button) {
    Button(
        modifier = button.modifier.build(),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = button.backgroundColor(),
            contentColor = button.contentColor(),
        ),
        onClick = button.action.action().action().action()
    ) {
        button.components?.forEach { component ->
            component.Inflate()
        }
    }
}