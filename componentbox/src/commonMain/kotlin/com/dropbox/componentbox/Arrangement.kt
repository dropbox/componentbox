package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents an arrangement along a horizontal or vertical axis.
 */
@Serializable
sealed interface Arrangement {
    /**
     * Represents an arrangement along a horizontal axis.
     */
    sealed interface Horizontal : Arrangement

    /**
     * Represents an arrangement along a vertical axis.
     */
    sealed interface Vertical : Arrangement

    /**
     * The start horizontal arrangement.
     */
    object Start : Horizontal

    /**
     * The end horizontal arrangement.
     */
    object End : Horizontal

    /**
     * The top vertical arrangement.
     */
    object Top : Vertical

    /**
     * The bottom vertical arrangement.
     */
    object Bottom : Vertical

    /**
     * The center arrangement, both horizontally and vertically.
     */
    object Center : Horizontal, Vertical

    /**
     * The space-between horizontal arrangement.
     * @property space The space to distribute between the children.
     */
    data class SpaceBetween(val space: Dp) : Horizontal

    /**
     * The space-around arrangement, both horizontally and vertically.
     * @property space The space to distribute around the children.
     */
    data class SpaceAround(val space: Dp) : Horizontal, Vertical

    /**
     * The space-evenly arrangement, both horizontally and vertically.
     * @property space The space to distribute evenly between and around the children.
     */
    data class SpaceEvenly(val space: Dp) : Horizontal, Vertical
}