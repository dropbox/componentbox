package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.BorderStroke
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Shape
import com.dropbox.componentbox.impl.ComponentBoxSurface

interface Surface {
    var shape: Shape?
    var color: Color?
    var contentColor: Color?
    var borderStroke: BorderStroke?
    var elevation: Int?
    val components: List<Component>?

    companion object {
        fun of(
            shape: Shape? = null,
            color: Color? = null,
            contentColor: Color? = null,
            borderStroke: BorderStroke? = null,
            elevation: Int? = null,
            components: List<Component>? = null,
        ): Surface = ComponentBoxSurface(
            shape = shape,
            color = color,
            contentColor = contentColor,
            borderStroke = borderStroke,
            elevation = elevation,
            components = components,
        )
    }
}