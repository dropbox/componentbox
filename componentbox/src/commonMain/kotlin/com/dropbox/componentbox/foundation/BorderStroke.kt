package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@IsPassable
@Serializable
data class BorderStroke(
    val width: Int,
    val color: Color
): Passable