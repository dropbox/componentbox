package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents an element of an annotated string, which can be either a Text or a Span.
 */
@Serializable
sealed interface AnnotatedStringElement {
    /**
     * Represents a piece of text with optional style information and a soft break flag.
     * @property text The text content.
     * @property style The style of the text, or null if not specified.
     * @property softBreak Whether the text should be followed by a soft break.
     */
    data class Text(
        val text: String,
        val style: TextStyle? = null,
        val softBreak: Boolean = false
    ) : AnnotatedStringElement


    /**
     * Represents a span of text with a style applied to it.
     * @property start The start index of the span in the annotated string.
     * @property end The end index of the span in the annotated string.
     * @property style The style applied to the span.
     */
    data class Span(
        val start: Int,
        val end: Int,
        val style: SpanStyle
    ) : AnnotatedStringElement
}



