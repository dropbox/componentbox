package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Parcelize
@Serializable
enum class Shape: Parcelable {
    RectangleShape,
    RoundedCornerShape,
    CircleShape
}