package com.dropbox.componentbox.samples.discovery.type

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dropbox.componentbox.foundation.RealTextStyle
import com.dropbox.componentbox.foundation.TextStyle
import com.dropbox.componentbox.foundation.Typography

actual object DiscoveryTypography : Typography {
    override val h1: TextStyle = RealTextStyle(
        name = "h1",
        fontFamily = headlineFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )

    override val h2: TextStyle = RealTextStyle(
        name = "h2",
        fontFamily = headlineFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    )

    override val h3: TextStyle = RealTextStyle(
        name = "h3",
        fontFamily = headlineFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )

    override val h4: TextStyle = RealTextStyle(
        name = "h4",
        fontFamily = headlineFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )

    override val h5: TextStyle = RealTextStyle(
        name = "h5",
        fontFamily = headlineFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )

    override val h6: TextStyle = RealTextStyle(
        name = "h6",
        fontFamily = headlineFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )

    override val body1: TextStyle = RealTextStyle(
        name = "body1",
        fontFamily = bodyFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )

    override val body2: TextStyle = RealTextStyle(
        name = "body2",
        fontFamily = bodyFontFamily(),
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )

    override val button: TextStyle = RealTextStyle(
        name = "button",
        fontFamily = buttonFontFamily(),
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )

    override val caption: TextStyle = RealTextStyle(
        name = "caption",
        fontFamily = captionFontFamily(),
        fontWeight = FontWeight.Light,
        fontSize = 8.sp
    )

    override fun list(): MutableList<TextStyle> = mutableListOf(
        h1, h2, h3, h4, h5, h6, body1, body2, button, caption
    )
}

@Composable
fun String?.textStyle(): TextStyle = when (this) {
    DiscoveryTypography.h1.name -> DiscoveryTypography.h1
    DiscoveryTypography.h2.name -> DiscoveryTypography.h2
    DiscoveryTypography.h3.name -> DiscoveryTypography.h3
    DiscoveryTypography.h4.name -> DiscoveryTypography.h4
    DiscoveryTypography.h5.name -> DiscoveryTypography.h5
    DiscoveryTypography.h6.name -> DiscoveryTypography.h6
    DiscoveryTypography.body1.name -> DiscoveryTypography.body1
    DiscoveryTypography.body2.name -> DiscoveryTypography.body2
    DiscoveryTypography.button.name -> DiscoveryTypography.button
    DiscoveryTypography.caption.name -> DiscoveryTypography.caption
    else -> DiscoveryTypography.body2
}

@Composable
fun TextStyle.textStyle(): androidx.compose.ui.text.TextStyle = when (this) {
    DiscoveryTypography.h1 -> androidx.compose.ui.text.TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
    DiscoveryTypography.h2 -> androidx.compose.ui.text.TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
    DiscoveryTypography.h3 -> androidx.compose.ui.text.TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
    DiscoveryTypography.h4 -> androidx.compose.ui.text.TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
    DiscoveryTypography.h5 -> androidx.compose.ui.text.TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
    DiscoveryTypography.h6 -> androidx.compose.ui.text.TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
    DiscoveryTypography.body1 -> androidx.compose.ui.text.TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
    DiscoveryTypography.body2 -> androidx.compose.ui.text.TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
    DiscoveryTypography.button -> androidx.compose.ui.text.TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
    DiscoveryTypography.caption -> androidx.compose.ui.text.TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
    else -> androidx.compose.ui.text.TextStyle(fontFamily = fontFamily, fontSize = fontSize, fontWeight = fontWeight)
}