package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents a text decoration.
 */
@Serializable
sealed interface TextDecoration {
    @Serializable
    data class DrawUnderline(val color: Color) : TextDecoration
    @Serializable
    data class DrawLineThrough(val color: Color) : TextDecoration
}