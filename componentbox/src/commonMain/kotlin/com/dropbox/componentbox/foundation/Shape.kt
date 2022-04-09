package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@IsPassable
@Serializable
enum class Shape: Passable {
    RectangleShape,
    RoundedCornerShape,
    CircleShape
}