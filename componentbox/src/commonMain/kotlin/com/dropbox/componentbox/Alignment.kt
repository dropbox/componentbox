package com.dropbox.componentbox

/**
 * Represents an alignment along a horizontal or vertical axis.
 */
sealed interface Alignment {
    /**
     * Represents an alignment along a horizontal axis.
     */
    sealed interface Horizontal : Alignment

    /**
     * Represents an alignment along a vertical axis.
     */
    sealed interface Vertical : Alignment

    /**
     * The start horizontal alignment.
     */
    object Start : Horizontal

    /**
     * The end horizontal alignment.
     */
    object End : Horizontal

    /**
     * The top vertical alignment.
     */
    object Top : Vertical

    /**
     * The bottom vertical alignment.
     */
    object Bottom : Vertical

    /**
     * The center alignment, both horizontally and vertically.
     */
    object Center : Horizontal, Vertical

    /**
     * The space-between horizontal alignment.
     *
     * @property space The space to distribute between the children.
     */
    data class SpaceBetween(val space: Dp) : Horizontal

    /**
     * The space-around alignment, both horizontally and vertically.
     *
     * @property space The space to distribute around the children.
     */
    data class SpaceAround(val space: Dp) : Horizontal, Vertical

    /**
     * The space-evenly alignment, both horizontally and vertically.
     *
     * @property space The space to distribute evenly between and around the children.
     */
    data class SpaceEvenly(val space: Dp) : Horizontal, Vertical
}


