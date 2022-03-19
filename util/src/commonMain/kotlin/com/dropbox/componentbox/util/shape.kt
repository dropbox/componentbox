package com.dropbox.componentbox.util

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.foundation.Shape

fun Shape?.translate(size: Dp = 0.dp) = when (this) {
    Shape.RectangleShape -> RectangleShape
    Shape.RoundedCornerShape -> RoundedCornerShape(size)
    Shape.CircleShape -> CircleShape
    null -> RoundedCornerShape(size)
}