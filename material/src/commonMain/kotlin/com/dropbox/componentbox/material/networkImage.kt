package com.dropbox.componentbox.material

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.NetworkImage
import com.dropbox.componentbox.kit.ComponentBoxKit

@Composable
internal fun <Id : Any> NetworkImage<Id>?.networkImage(kit: ComponentBoxKit) {
    if (this != null) {
        Image(
            painter = kit.converter.image(this),
            modifier = kit.converter.modifier(modifier),
            contentScale = kit.converter.contentScale(contentScale),
            contentDescription = contentDescription
        )
    }
}
