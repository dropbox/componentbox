package com.dropbox.componentbox

/**
 * Represents a font style.
 */
sealed class FontStyle {
    object Normal : FontStyle()
    object Italic : FontStyle()
    object Oblique : FontStyle()
}