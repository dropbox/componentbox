package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Serializable
enum class Shape: Parcelable {
    RectangleShape,
    RoundedCornerShape,
    CircleShape
}