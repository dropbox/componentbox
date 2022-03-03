package com.dropbox.componentbox.models

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

actual interface TextStyle {
    val name: String
    val fontFamily: FontFamily
    val fontWeight: FontWeight
    val fontSize: TextUnit
}

data class RealTextStyle(
    override val name: String,
    override val fontFamily: FontFamily,
    override val fontWeight: FontWeight,
    override val fontSize: TextUnit
) : TextStyle