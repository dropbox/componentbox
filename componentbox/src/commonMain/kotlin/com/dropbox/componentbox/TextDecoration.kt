package com.dropbox.componentbox

/**
 * Represents a text decoration.
 */
sealed interface TextDecoration {
    data class DrawUnderline(val color: Color) : TextDecoration
    data class DrawLineThrough(val color: Color) : TextDecoration
}