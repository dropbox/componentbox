package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents a text decoration.
 */
@Serializable
sealed interface TextDecoration {
    data class DrawUnderline(val color: Color) : TextDecoration
    data class DrawLineThrough(val color: Color) : TextDecoration
}