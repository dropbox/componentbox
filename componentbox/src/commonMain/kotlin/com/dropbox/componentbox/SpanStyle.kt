package com.dropbox.componentbox

/**
 * Represents a style to be applied to a span of text.
 * @property color The text color to be applied to the span, or null if not specified.
 * @property backgroundColor The background color to be applied to the span, or null if not specified.
 * @property fontStyle The font style to be applied to the span, or null if not specified.
 * @property fontWeight The font weight to be applied to the span, or null if not specified.
 * @property fontSize The font size to be applied to the span, or null if not specified.
 * @property letterSpacing The letter spacing to be applied to the span, or null if not specified.
 * @property textDecoration The text decoration to be applied to the span, or null if not specified.
 */
data class SpanStyle(
    val color: Color? = null,
    val backgroundColor: Color? = null,
    val fontStyle: FontStyle? = null,
    val fontWeight: FontWeight? = null,
    val fontSize: TextUnit? = null,
    val letterSpacing: TextUnit? = null,
    val textDecoration: TextDecoration? = null
) {
    companion object {
        fun from(style: SpanStyle? = null): SpanStyleBuilder = SpanStyleBuilder(style ?: SpanStyle())
    }

    class SpanStyleBuilder(private var style: SpanStyle) {
        fun color(color: Color) {
            style = style.copy(color = color)
        }

        fun backgroundColor(color: Color) {
            style = style.copy(backgroundColor = color)
        }

        fun fontStyle(fontStyle: FontStyle) {
            style = style.copy(fontStyle = fontStyle)
        }

        fun fontWeight(fontWeight: FontWeight) {
            style = style.copy(fontWeight = fontWeight)
        }

        fun fontSize(fontSize: TextUnit) {
            style = style.copy(fontSize = fontSize)
        }

        fun letterSpacing(letterSpacing: TextUnit) {
            style = style.copy(letterSpacing = letterSpacing)
        }

        fun textDecoration(textDecoration: TextDecoration) {
            style = style.copy(textDecoration = textDecoration)
        }

        fun build() = style
    }
}