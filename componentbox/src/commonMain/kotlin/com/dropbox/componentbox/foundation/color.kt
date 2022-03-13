package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Serializable
data class Color(
    val title: String,
    val light: Long,
    val dark: Long
)

interface Colors {
    val primary: Color
    val primaryVariant: Color
    val secondary: Color
    val secondaryVariant: Color
    val background: Color
    val surface: Color
    val error: Color
    val onPrimary: Color
    val onSecondary: Color
    val onBackground: Color
    val onSurface: Color
    val onError: Color
    fun list(): MutableList<Color>
}