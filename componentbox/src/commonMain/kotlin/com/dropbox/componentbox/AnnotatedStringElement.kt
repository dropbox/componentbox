package com.dropbox.componentbox

import androidx.compose.runtime.Composable
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
    @Serializable
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
    @Serializable
    data class Span(
        val start: Int,
        val end: Int,
        val style: SpanStyle
    ) : AnnotatedStringElement

    /**
     * Represents the inline content added to an [AnnotatedString].
     * Used to store the content ID and associated [InlineTextContent].
     */

    data class InlineContent(
        val id: String,
        val content: InlineTextContent
    ) : AnnotatedStringElement
}

/**
 * Used to define the inline content that will be displayed within a [Text] component.
 * @param placeholder A [Placeholder] object that defines the size and vertical alignment of the space reserved for the inline content.
 * @param content A composable function that represents the inline content to be displayed within the reserved space.
 */

data class InlineTextContent(
    val placeholder: Placeholder,
    val content: @Composable () -> Unit
)


/**
 * Used to reserve space for inline content within a [Text] component.
 * @param width The width of the placeholder.
 * @param height The height of the placeholder.
 * @param verticalAlign A [PlaceholderVerticalAlign] enum value that specifies how the placeholder should be vertically aligned with respect to the surrounding text.
 */
@Serializable
data class Placeholder(
    val width: TextUnit.Sp,
    val height: TextUnit.Sp,
    val verticalAlign: PlaceholderVerticalAlign
)

/**
 * Used to define the vertical alignment of a [Placeholder] with respect to the surrounding text.
 */
enum class PlaceholderVerticalAlign {
    TextTop,
    TextCenter,
    TextBottom,
    AboveBaseline,
    BelowBaseline
}

