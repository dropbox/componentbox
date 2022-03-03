package com.dropbox.componentbox.samples.discovery.type

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font

val atlasGroteskFontFamily =
    FontFamily(
        listOf(
            Font("font/atlasgrotesk_medium.ttf"),
        )
    )

val sharpGroteskBookFontFamily =
    FontFamily(
        listOf(
            Font("font/sharpgrotesk_book.ttf")
        )
    )

actual fun defaultFontFamily(): FontFamily = sharpGroteskBookFontFamily
actual fun headlineFontFamily(): FontFamily = sharpGroteskBookFontFamily
actual fun bodyFontFamily(): FontFamily = atlasGroteskFontFamily
actual fun buttonFontFamily(): FontFamily = atlasGroteskFontFamily
actual fun captionFontFamily(): FontFamily = atlasGroteskFontFamily