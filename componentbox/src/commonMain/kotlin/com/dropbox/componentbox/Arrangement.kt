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
    @Serializable
    sealed interface Horizontal : Arrangement

    /**
     * Represents an arrangement along a vertical axis.
     */
    @Serializable
    sealed interface Vertical : Arrangement

    /**
     * The start horizontal arrangement.
     */
    @Serializable
    object Start : Horizontal

    /**
     * The end horizontal arrangement.
     */
    @Serializable
    object End : Horizontal

    /**
     * The top vertical arrangement.
     */
    @Serializable
    object Top : Vertical

    /**
     * The bottom vertical arrangement.
     */
    @Serializable
    object Bottom : Vertical

    /**
     * The center arrangement, both horizontally and vertically.
     */
    @Serializable
    object Center : Horizontal, Vertical

    /**
     * The space-between horizontal arrangement.
     * @property space The space to distribute between the children.
     */
    @Serializable
    data class SpaceBetween(val space: Dp) : Horizontal

    /**
     * The space-around arrangement, both horizontally and vertically.
     * @property space The space to distribute around the children.
     */
    @Serializable
    data class SpaceAround(val space: Dp) : Horizontal, Vertical

    /**
     * The space-evenly arrangement, both horizontally and vertically.
     * @property space The space to distribute evenly between and around the children.
     */
    @Serializable
    data class SpaceEvenly(val space: Dp) : Horizontal, Vertical
}