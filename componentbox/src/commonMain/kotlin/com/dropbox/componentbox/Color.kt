package com.dropbox.componentbox

/**
 * Represents a color, which can be either in RGB format or hexadecimal format.
 */
sealed class Color {

    /**
     * Represents a color in RGB format.
     * @property red The value of the red channel.
     * @property green The value of the green channel.
     * @property blue The value of the blue channel.
     * @property alpha The value of the alpha channel, which defaults to 1.0 if not specified.
     */

    data class Rgb(val red: Int, val green: Int, val blue: Int, val alpha: Float = 1f) : Color()

    /**
     * Represents a color in hexadecimal format.
     * @property value The hexadecimal value of the color.
     */
    data class Hex(val value: String) : Color()

    /**
     * Represents a color identified by name.
     * @property value The name of the color.
     */
    data class Name(val value: String) : Color()

    companion object {
        fun rgb(red: Int, green: Int, blue: Int, alpha: Float = 1f): Color = Rgb(red, green, blue, alpha)
        fun hex(value: String): Color = Hex(value)
        fun named(value: String): Color = Name(value)
    }
}