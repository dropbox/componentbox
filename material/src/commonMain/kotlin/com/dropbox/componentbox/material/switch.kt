package com.dropbox.componentbox.material

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.Switch
import com.dropbox.componentbox.kit.ComponentBoxKit

@Composable
internal fun Switch.switch(kit: ComponentBoxKit) {
    Switch(
        modifier = kit.converter.modifier(modifier),
        checked = checked ?: false,
        onCheckedChange = {
            kit.eventHandler.handle(this.events?.onCheckedChange)
        },
    )
}