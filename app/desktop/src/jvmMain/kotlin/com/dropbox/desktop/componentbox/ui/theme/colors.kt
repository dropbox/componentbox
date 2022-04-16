package com.dropbox.desktop.componentbox.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material.Colors as RealColors

object Colors {
    val Light = RealColors(
        primary = Color(0xFF0061FE),
        primaryVariant = Color(0xFF1E1919),
        secondary = Color(0xFFF7F5F2),
        secondaryVariant = Color(0xFF1E1918),
        background = Color(0xFFFFFFFF),
        surface = Color(0xFFFBFAF9),
        error = Color(0xFF9B0032),
        onPrimary = Color(0xFFF7F5F2),
        onSecondary = Color(0xFFF7F5F2),
        onBackground = Color(0xFF1E1919),
        onSurface = Color(0xFF1E1919),
        onError = Color(0xFFF7F5F2),
        isLight = true,
    )

    val Dark = RealColors(
        primary = Color(0xFF3984FF),
        primaryVariant = Color(0xFF3984FF),
        secondary = Color(0xFF3984FF),
        secondaryVariant = Color(0xFF3984FF),
        background = Color(0xFF161313),
        surface = Color(0xFF3984FF),
        error = Color(0xFFFA551E),
        onPrimary = Color(0xFF3984FF),
        onSecondary = Color(0xFF3984FF),
        onBackground = Color(0xFFFFFFFF),
        onSurface = Color(0xFF3984FF),
        onError = Color(0xFF3984FF),
        isLight = false,
    )
}

val RealColors.disabledBackground: Color
    @Composable
    get() = if (isLight) Color(0xFFC0BBB4) else Color(0xFFD8D3CB)

val RealColors.standardBackgroundElevated: Color
    @Composable
    get() = if (isLight) Color(0xFFFBFAF9) else Color(0xFF2B2929)

val RealColors.successFill: Color
    @Composable
    get() = if (isLight) Color(0xFFB4DC19) else Color(0xFFB4DC19)

val RealColors.faintText: Color
    @Composable
    get() = if (isLight) Color(0xC7524A3E) else Color(0x99F7F5F6)

val RealColors.standardText: Color
    @Composable
    get() = if (isLight) Color(0xFF1E1919) else Color(0xFFF7F5F9)

val RealColors.buttonBackground: Color
    @Composable
    get() = if (isLight) Color(0xFFFFFFFF) else Color(0xff404754)

val RealColors.realBackground: Color
    @Composable
    get() = if (isLight) Color(0xFFFFFFFF) else Color(0xff282c34)

val RealColors.paperBackground: Color
    @Composable
    get() = if (isLight) Color(0xFFFFFFFF) else Color(0xff21252b)

val RealColors.grayPrimary: Color
    @Composable
    get() = if (isLight) Color(0xFFFFFFFF) else Color(0xff424242)

val RealColors.standardBackground: Color
    @Composable
    get() = if (isLight) Color(0xFFFFFFFF) else Color(0xFF161313)

val RealColors.inverseStandardBackground: Color
    @Composable
    get() = if (isLight) Color(0xFF000000) else Color(0xFFFFFFFF)
