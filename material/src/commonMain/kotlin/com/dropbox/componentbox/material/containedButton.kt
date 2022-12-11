package com.dropbox.componentbox.material

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.ContainedButton
import com.dropbox.componentbox.kit.ComponentBoxKit

@Composable
internal fun ContainedButton.containedButton(kit: ComponentBoxKit) {

    val colors = if (modifier?.background != null) {
        ButtonDefaults.buttonColors(
            backgroundColor = kit.converter.color(modifier!!.background!!),
        )
    } else ButtonDefaults.buttonColors()

    Button(
        modifier = kit.converter.modifier(modifier),
        colors = colors,
        onClick = {
            kit.eventHandler.handle(events?.onClick)
        }
    ) {
        components?.forEach { component ->
            component.material(kit)
        }
    }
}