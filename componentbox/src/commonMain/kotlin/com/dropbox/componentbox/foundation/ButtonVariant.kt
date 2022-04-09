package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@IsPassable
@Serializable
enum class ButtonVariant: Passable {
    Contained,
    Text,
    Outlined,
    Icon
}