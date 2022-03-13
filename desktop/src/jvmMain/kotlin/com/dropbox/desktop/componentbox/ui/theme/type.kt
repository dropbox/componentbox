package com.dropbox.desktop.componentbox.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.sp
import androidx.compose.material.Typography as RealTypography

val sharpGroteskBookFont = Font("font/sharpgrotesk_book.ttf")
val sharpGroteskBookFontFamily = FontFamily(listOf(sharpGroteskBookFont))
val atlasGroteskRegularFont = Font("font/atlasgrotesk_regular.ttf")
val atlasGroteskFontFamily = FontFamily(listOf(atlasGroteskRegularFont))

val Typography = RealTypography(
    defaultFontFamily = sharpGroteskBookFontFamily,
    h1 = TextStyle(fontFamily = sharpGroteskBookFontFamily, fontWeight = FontWeight.Bold, fontSize = 24.sp),
    h2 = TextStyle(fontFamily = sharpGroteskBookFontFamily, fontWeight = FontWeight.Bold, fontSize = 22.sp),
    h3 = TextStyle(fontFamily = sharpGroteskBookFontFamily, fontWeight = FontWeight.Bold, fontSize = 20.sp),
    h4 = TextStyle(fontFamily = sharpGroteskBookFontFamily, fontWeight = FontWeight.Bold, fontSize = 18.sp),
    h5 = TextStyle(fontFamily = sharpGroteskBookFontFamily, fontWeight = FontWeight.Bold, fontSize = 16.sp),
    h6 = TextStyle(fontFamily = sharpGroteskBookFontFamily, fontWeight = FontWeight.Bold, fontSize = 14.sp),
    body1 = TextStyle(fontFamily = atlasGroteskFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    body2 = TextStyle(fontFamily = atlasGroteskFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp),
    button = TextStyle(fontFamily = atlasGroteskFontFamily, fontWeight = FontWeight.Bold, fontSize = 14.sp),
    caption = TextStyle(fontFamily = atlasGroteskFontFamily, fontWeight = FontWeight.Light, fontSize = 8.sp),
)