package com.dropbox.componentbox

import kotlinx.serialization.Serializable


/**
 * Represents the shape of a UI element.
 */
@Serializable
sealed class Shape {
    /**
     * The circular shape.
     */
    object Circle : Shape()

    /**
     * The cut corner shape.
     */
    object CutCorner : Shape()

    /**
     * The rectangular shape.
     */
    object Rectangle : Shape()

    /**
     * The rounded corner shape.
     *
     * @property size The size of the rounded corner.
     */
    data class RoundedCorner(val size: Dp) : Shape()
}