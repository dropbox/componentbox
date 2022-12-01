package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.foundation.TextStyle
import com.dropbox.componentbox.impl.ComponentBoxText

interface Text : Component {
    var text: String?
    val color: Color?
    val textStyle: TextStyle?

    companion object {
        fun of(
            modifier: Modifier? = null,
            actions: Actions? = null,
            text: String? = null,
            color: Color? = null,
            textStyle: TextStyle? = null,
        ): Text = ComponentBoxText(
            modifier = modifier,
            actions = actions,
            text = text,
            color = color,
            textStyle = textStyle,
        )
    }
}