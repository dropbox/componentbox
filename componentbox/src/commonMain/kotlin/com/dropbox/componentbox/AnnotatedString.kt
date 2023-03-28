package com.dropbox.componentbox

import kotlinx.serialization.Serializable


/**
 * Enables text with inline styling.
 * @param elements List of [AnnotatedStringElement] which can be plain text or styled spans.
 * @property text Convenience method for creating and adding [AnnotatedStringElement.Text]
 * @property span Convenience method for creating and adding [AnnotatedStringElement.Span]
 */
@Serializable
data class AnnotatedString(
    val elements: MutableList<AnnotatedStringElement> = mutableListOf()
) : Component {
    fun text(text: String, style: TextStyle? = null, softBreak: Boolean = false) {
        elements.add(AnnotatedStringElement.Text(text, style, softBreak))
    }

    fun span(start: Int, end: Int, style: SpanStyle) {
        elements.add(AnnotatedStringElement.Span(start, end, style))
    }

    fun inlineContent(id: String, content: InlineTextContent) {
        elements.add(AnnotatedStringElement.InlineContent(id, content))
    }
}