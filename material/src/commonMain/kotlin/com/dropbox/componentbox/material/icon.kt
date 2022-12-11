package com.dropbox.componentbox.material

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.Icon
import com.dropbox.componentbox.kit.ComponentBoxKit

@Composable
internal fun <Id : Any> Icon<Id>?.icon(kit: ComponentBoxKit) {
    if (this != null) {
        if (color != null) {
            Icon(
                painter = kit.converter.icon(this),
                contentDescription = contentDescription,
                modifier = kit.converter.modifier(modifier),
                tint = kit.converter.color(color!!)
            )
        } else {
            Icon(
                painter = kit.converter.icon(this),
                contentDescription = contentDescription,
                modifier = kit.converter.modifier(modifier),
            )
        }
    }
}