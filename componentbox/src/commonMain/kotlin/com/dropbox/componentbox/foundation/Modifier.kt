package com.dropbox.componentbox.foundation

import com.dropbox.componentbox.impl.ComponentBoxModifier

interface Modifier {
    var fillMaxSize: Boolean?
    var fillMaxHeight: Boolean?
    var fillMaxWidth: Boolean?
    var height: Int?
    var width: Int?
    var padding: Padding?
    var margin: Margin?
    var background: Color?
    var weight: Float?

    companion object {
        fun of(
            fillMaxSize: Boolean? = null,
            fillMaxHeight: Boolean? = null,
            fillMaxWidth: Boolean? = null,
            height: Int? = null,
            width: Int? = null,
            padding: Padding? = null,
            margin: Margin? = null,
            background: Color? = null,
            weight: Float? = null,
        ): Modifier = ComponentBoxModifier(
            fillMaxSize = fillMaxSize,
            fillMaxHeight = fillMaxHeight,
            fillMaxWidth = fillMaxWidth,
            height = height,
            width = width,
            padding = padding,
            margin = margin,
            background = background,
            weight = weight
        )
    }
}

fun Modifier.fillMaxSize(value: Boolean) = apply { fillMaxSize = value }
fun Modifier.fillMaxHeight(value: Boolean) = apply { fillMaxHeight = value }
fun Modifier.fillMaxWidth(value: Boolean) = apply { fillMaxWidth = value }
fun Modifier.height(value: Int) = apply { height = value }
fun Modifier.width(value: Int) = apply { width = value }
fun Modifier.padding(value: Padding) = apply { padding = value }
fun Modifier.margin(value: Margin) = apply { margin = value }
fun Modifier.background(value: Color) = apply { background = value }
fun Modifier.weight(value: Float) = apply { weight = value }
