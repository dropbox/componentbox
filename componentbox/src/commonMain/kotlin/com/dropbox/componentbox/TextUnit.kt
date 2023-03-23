package com.dropbox.componentbox


/**
 * Represents a text unit, which can be either in scaled pixels or pixels.
 */
sealed class TextUnit {

    /**
     * Represents a text unit in scaled pixels.
     * @property value The value of the text unit in scaled pixels.
     */
    data class Sp(val value: Float) : TextUnit()

    /**
     * Represents a text unit in pixels.
     * @property value The value of the text unit in pixels.
     */
    data class Px(val value: Int) : TextUnit()

    companion object {
        fun sp(value: Float): TextUnit = Sp(value)
        fun px(value: Int): TextUnit = Px(value)
    }
}