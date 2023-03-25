package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents a modifier to be applied to a UI element.
 * @property background The background color to be applied to the UI element.
 * @property border The border to be applied to the UI element.
 * @property padding The padding values to be applied to the UI element.
 * @property size The size of the UI element.
 * @property shape The shape of the UI element.
 * @property alpha The alpha value to be applied to the UI element.
 * @property rotation The rotation angle to be applied to the UI element.
 * @property scaleX The horizontal scale factor to be applied to the UI element.
 * @property scaleY The vertical scale factor to be applied to the UI element.
 * @property offset The offset values to be applied to the UI element.
 * @property zIndex The z-index value to be applied to the UI element.
 * @property clip Whether clipping should be applied to the UI element.
 */
@Serializable
data class Modifier(
    val background: Color? = null,
    val border: Border? = null,
    val padding: PaddingValues? = null,
    val size: Size? = null,
    val shape: Shape? = null,
    val alpha: Float = 1f,
    val rotation: Float = 0f,
    val scaleX: Float = 1f,
    val scaleY: Float = 1f,
    val offset: Offset? = null,
    val zIndex: Float = 0f,
    val clip: Boolean = true
)

/**
 * Represents a border to be applied to a UI element.
 * @property width The width of the border.
 * @property color The color of the border.
 * @property shape The shape of the border.
 */
@Serializable
data class Border(
    val width: Dp,
    val color: Color,
    val shape: Shape
)


/**
 * Represents padding values to be applied to a UI element.
 * @property start The start padding value.
 * @property top The top padding value.
 * @property end The end padding value.
 * @property bottom The bottom padding value.
 */
@Serializable
data class PaddingValues(
    val start: Dp,
    val top: Dp,
    val end: Dp,
    val bottom: Dp
)


/**
 * Represents the size of a UI element.
 * @property width The width of the UI element.
 * @property height The height of the UI element.
 */
@Serializable
data class Size(
    val width: Dp,
    val height: Dp
)

/**
 * Represents a dimension value in density-independent pixels.
 * @property value The value of the dimension in density-independent pixels.
 */
@Serializable
data class Dp(val value: Float) {
    operator fun plus(other: Dp): Dp = Dp(value + other.value)
    operator fun minus(other: Dp): Dp = Dp(value - other.value)
    operator fun times(scalar: Float): Dp = Dp(value * scalar)
    operator fun div(scalar: Float): Dp = Dp(value / scalar)
}

val Float.dp: Dp
    get() = Dp(this)

val Int.dp: Dp
    get() = Dp(this.toFloat())


/**
 * Represents the offset of a UI element in density-independent pixels.
 * @property x The horizontal offset value.
 * @property y The vertical offset value.
 */
@Serializable
data class Offset(
    val x: Dp = 0.dp,
    val y: Dp = 0.dp
)