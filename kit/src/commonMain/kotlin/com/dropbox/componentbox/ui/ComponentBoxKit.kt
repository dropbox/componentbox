package com.dropbox.componentbox.ui

import androidx.compose.ui.graphics.painter.Painter
import com.dropbox.componentbox.component.ContentScale
import com.dropbox.componentbox.component.Icon
import com.dropbox.componentbox.component.Image
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.foundation.TextStyle
import androidx.compose.foundation.layout.Arrangement as ComposeArrangement
import androidx.compose.ui.Alignment as ComposeAlignment
import androidx.compose.ui.Modifier as ComposeModifier
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.layout.ContentScale as ComposeContentScale
import androidx.compose.ui.text.TextStyle as ComposeTextStyle

interface ComponentBoxKit {
    val eventHandler: (action: ComponentBoxEvent?) -> Unit
    val textProcessor: (text: String) -> String
    val converter: Converter

    interface Converter {
        fun modifier(modifier: Modifier?): ComposeModifier
        fun color(color: Color): ComposeColor
        fun textStyle (textStyle: TextStyle?): ComposeTextStyle?
        fun contentScale (contentScale: ContentScale?): ComposeContentScale
        fun verticalArrangement (arrangement: Arrangement.Vertical?): ComposeArrangement.Vertical?
        fun verticalAlignment (alignment: Alignment.Vertical?): ComposeAlignment.Vertical?
        fun horizontalArrangement (arrangement: Arrangement.Horizontal?): ComposeArrangement.Horizontal?
        fun horizontalAlignment (alignment: Alignment.Horizontal?): ComposeAlignment.Horizontal?
        fun image (image: Image): Painter
        fun icon (icon: Icon<*>): Painter
    }
}