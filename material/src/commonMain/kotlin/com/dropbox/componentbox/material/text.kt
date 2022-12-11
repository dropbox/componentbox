package com.dropbox.componentbox.material

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.Text
import com.dropbox.componentbox.kit.ComponentBoxKit

@Composable
internal fun Text.text(kit: ComponentBoxKit) {
    if (text != null) {
        val style = kit.converter.textStyle(textStyle)
        if (style != null) {
            if (color != null) {
                Text(
                    text = kit.textProcessor.process(text!!),
                    style = style,
                    modifier = kit.converter.modifier(modifier),
                    color = kit.converter.color(color!!)
                )
            } else {
                Text(
                    text = kit.textProcessor.process(text!!),
                    modifier = kit.converter.modifier(modifier),
                    style = style
                )
            }
        } else {
            if (color != null) {
                Text(
                    text = kit.textProcessor.process(text!!),
                    modifier = kit.converter.modifier(modifier),
                    color = kit.converter.color(color!!)
                )
            } else {
                Text(
                    text = kit.textProcessor.process(text!!),
                    modifier = kit.converter.modifier(modifier),
                )
            }
        }
    }
}
