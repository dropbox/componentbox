package com.dropbox.componentbox.ui

import androidx.compose.ui.graphics.painter.Painter
import com.dropbox.componentbox.component.ContentScale
import com.dropbox.componentbox.component.Icon
import com.dropbox.componentbox.component.Image
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.ComponentBoxAction
import com.dropbox.componentbox.foundation.Modifier
import androidx.compose.ui.Modifier as ComposeModifier
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.layout.ContentScale as ComposeContentScale

interface ComponentBoxKit {
    val modifierTransformer: (modifier: Modifier?) -> ComposeModifier
    val actionHandler: (action: ComponentBoxAction?) -> Unit
    val colorTransformer: (color: Color) -> ComposeColor
    val textProcessor: (text: String?) -> String?
    val imagePainterConverter: (image: Image) -> Painter
    val iconPainterConverter: (icon: Icon<*>) -> Painter
    val contentScaleTransformer: (contentScale: ContentScale?) -> ComposeContentScale
}
