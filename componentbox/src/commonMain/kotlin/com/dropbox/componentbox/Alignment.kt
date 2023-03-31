package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents an alignment along a horizontal or vertical axis.
 */
@Serializable
sealed interface Alignment {
    /**
     * Represents an alignment along a horizontal axis.
     */
    @Serializable
    sealed interface Horizontal : Alignment

    /**
     * Represents an alignment along a vertical axis.
     */
    @Serializable
    sealed interface Vertical : Alignment

    /**
     * The start horizontal alignment.
     */
    @Serializable
    object Start : Horizontal

    /**
     * The end horizontal alignment.
     */
    @Serializable
    object End : Horizontal

    /**
     * The top vertical alignment.
     */
    @Serializable
    object Top : Vertical

    /**
     * The bottom vertical alignment.
     */
    @Serializable
    object Bottom : Vertical

    /**
     * The center alignment, both horizontally and vertically.
     */
    @Serializable
    object Center : Horizontal, Vertical

    /**
     * The space-between horizontal alignment.
     *
     * @property space The space to distribute between the children.
     */
    @Serializable
    data class SpaceBetween(val space: Dp) : Horizontal

    /**
     * The space-around alignment, both horizontally and vertically.
     *
     * @property space The space to distribute around the children.
     */
    @Serializable
    data class SpaceAround(val space: Dp) : Horizontal, Vertical

    /**
     * The space-evenly alignment, both horizontally and vertically.
     *
     * @property space The space to distribute evenly between and around the children.
     */
    @Serializable
    data class SpaceEvenly(val space: Dp) : Horizontal, Vertical
}


