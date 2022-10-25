package com.dropbox.componentbox.material

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.Icon
import com.dropbox.componentbox.ui.ComponentBoxKit

@Composable
internal fun <Id : Any> Icon<Id>?.icon(kit: ComponentBoxKit) {
    if (this != null) {
        if (color != null) {
            Icon(
                painter = kit.iconPainterConverter(this),
                contentDescription = contentDescription,
                modifier = kit.modifierTransformer(modifier),
                tint = kit.colorTransformer(color!!)
            )
        } else {
            Icon(
                painter = kit.iconPainterConverter(this),
                contentDescription = contentDescription,
                modifier = kit.modifierTransformer(modifier),
            )
        }
    }
}