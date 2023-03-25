package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents a font weight.
 */
@Serializable
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