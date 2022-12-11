package com.dropbox.componentbox.kit

import androidx.compose.ui.graphics.painter.Painter
import com.dropbox.componentbox.component.ContentScale
import com.dropbox.componentbox.component.Icon
import com.dropbox.componentbox.component.Image
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.foundation.TextStyle

interface Converter {
    fun modifier(modifier: Modifier?): androidx.compose.ui.Modifier
    fun color(color: Color): androidx.compose.ui.graphics.Color
    fun textStyle(textStyle: TextStyle?): androidx.compose.ui.text.TextStyle?
    fun contentScale(contentScale: ContentScale?): androidx.compose.ui.layout.ContentScale
    fun verticalArrangement(arrangement: Arrangement.Vertical?): androidx.compose.foundation.layout.Arrangement.Vertical?
    fun verticalAlignment(alignment: Alignment.Vertical?): androidx.compose.ui.Alignment.Vertical?
    fun horizontalArrangement(arrangement: Arrangement.Horizontal?): androidx.compose.foundation.layout.Arrangement.Horizontal?
    fun horizontalAlignment(alignment: Alignment.Horizontal?): androidx.compose.ui.Alignment.Horizontal?
    fun image(image: Image): Painter
    fun icon(icon: Icon<*>): Painter
}