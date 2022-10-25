package com.dropbox.componentbox.ui

import androidx.compose.ui.graphics.painter.Painter
import com.dropbox.componentbox.component.ContentScale
import com.dropbox.componentbox.component.Icon
import com.dropbox.componentbox.component.Image
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.ComponentBoxAction
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.foundation.TextStyle
import androidx.compose.foundation.layout.Arrangement as ComposeArrangement
import androidx.compose.ui.Alignment as ComposeAlignment

import androidx.compose.ui.Modifier as ComposeModifier
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.layout.ContentScale as ComposeContentScale
import androidx.compose.ui.text.TextStyle as ComposeTextStyle

interface ComponentBoxKit {
    val actionHandler: (action: ComponentBoxAction?) -> Unit
    val textProcessor: (text: String) -> String
    val modifierTransformer: (modifier: Modifier?) -> ComposeModifier
    val colorTransformer: (color: Color) -> ComposeColor
    val textStyleTransformer: (textStyle: TextStyle?) -> ComposeTextStyle?
    val contentScaleTransformer: (contentScale: ContentScale?) -> ComposeContentScale
    val verticalArrangementTransformer: (arrangement: Arrangement.Vertical?) -> ComposeArrangement.Vertical?
    val verticalAlignmentTransformer: (alignment: Alignment.Vertical?) -> ComposeAlignment.Vertical?
    val horizontalArrangementTransformer: (arrangement: Arrangement.Horizontal?) -> ComposeArrangement.Horizontal?
    val horizontalAlignmentTransformer: (alignment: Alignment.Horizontal?) -> ComposeAlignment.Horizontal?
    val imagePainterConverter: (image: Image) -> Painter
    val iconPainterConverter: (icon: Icon<*>) -> Painter
}
