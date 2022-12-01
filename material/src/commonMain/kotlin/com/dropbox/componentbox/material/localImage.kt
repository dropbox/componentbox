package com.dropbox.componentbox.material

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.LocalImage
import com.dropbox.componentbox.ui.ComponentBoxKit

@Composable
internal fun <Id : Any> LocalImage<Id>?.localImage(kit: ComponentBoxKit) {
    if (this != null) {
        Image(
            painter = kit.imagePainterConverter(this),
            modifier = kit.modifierTransformer(modifier),
            contentScale = kit.contentScaleTransformer(contentScale),
            contentDescription = contentDescription
        )
    }
}