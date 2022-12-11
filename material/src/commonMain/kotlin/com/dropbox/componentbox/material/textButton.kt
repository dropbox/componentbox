package com.dropbox.componentbox.material

import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.TextButton
import com.dropbox.componentbox.ui.ComponentBoxKit

@Composable
internal fun TextButton.textButton(kit: ComponentBoxKit) {
    val colors = if (modifier?.background != null) {
        ButtonDefaults.buttonColors(
            backgroundColor = kit.converter.color(modifier!!.background!!),
        )
    } else ButtonDefaults.buttonColors()

    TextButton(
        modifier = kit.converter.modifier(modifier),
        colors = colors,
        onClick = {
            kit.eventHandler(events?.onClick)
        }
    ) {
        components?.forEach { component ->
            component.material(kit)
        }
    }
}