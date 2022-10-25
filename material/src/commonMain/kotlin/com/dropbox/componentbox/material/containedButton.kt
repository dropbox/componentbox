package com.dropbox.componentbox.material

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.ContainedButton
import com.dropbox.componentbox.ui.ComponentBoxKit

@Composable
internal fun ContainedButton.containedButton(kit: ComponentBoxKit) {

    val colors = if (modifier?.background != null) {
        ButtonDefaults.buttonColors(
            backgroundColor = kit.colorTransformer(modifier!!.background!!),
        )
    } else ButtonDefaults.buttonColors()

    Button(
        modifier = kit.modifierTransformer(modifier),
        colors = colors,
        onClick = {
            kit.actionHandler(actions?.onClick)
        }
    ) {
        components?.forEach { component ->
            component.material(kit)
        }
    }
}