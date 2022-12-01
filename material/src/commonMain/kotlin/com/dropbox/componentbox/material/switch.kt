package com.dropbox.componentbox.material

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.Switch
import com.dropbox.componentbox.ui.ComponentBoxKit

@Composable
internal fun Switch.switch(kit: ComponentBoxKit) {
    Switch(
        modifier = kit.modifierTransformer(modifier),
        checked = checked ?: false,
        onCheckedChange = {
            kit.actionHandler(this.actions?.onCheckedChange)
        },
    )
}