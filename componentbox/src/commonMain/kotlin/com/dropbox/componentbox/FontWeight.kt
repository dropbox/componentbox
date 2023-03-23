package com.dropbox.componentbox

/**
 * Represents a font weight.
 */
sealed class FontWeight {
    object Thin : FontWeight()
    object ExtraLight : FontWeight()
    object Light : FontWeight()
    object Normal : FontWeight()
    object Medium : FontWeight()
    object SemiBold : FontWeight()
    object Bold : FontWeight()
    object ExtraBold : FontWeight()
    object Black : FontWeight()
}