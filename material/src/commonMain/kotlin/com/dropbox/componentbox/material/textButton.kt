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
            backgroundColor = kit.colorTransformer(modifier!!.background!!),
        )
    } else ButtonDefaults.buttonColors()

    TextButton(
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