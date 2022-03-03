package com.dropbox.componentbox.samples.discovery.type

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.dropbox.componentbox.discovery.theme.R

val sharpGroteskBookFontFamily = FontFamily(listOf(Font(R.font.sharp_grotesk_book)))
val atlasGroteskFontFamily = FontFamily(listOf(Font(R.font.atlasgrotesk_medium)))

actual fun defaultFontFamily(): FontFamily = sharpGroteskBookFontFamily
actual fun headlineFontFamily(): FontFamily = sharpGroteskBookFontFamily
actual fun bodyFontFamily(): FontFamily = atlasGroteskFontFamily
actual fun buttonFontFamily(): FontFamily = atlasGroteskFontFamily
actual fun captionFontFamily(): FontFamily = atlasGroteskFontFamily