package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Serializable
data class BorderStroke(
    val width: Int,
    val color: Color
): Parcelable