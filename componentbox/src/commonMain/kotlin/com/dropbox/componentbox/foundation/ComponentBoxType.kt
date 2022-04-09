package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@IsPassable
@Serializable
enum class ComponentBoxType: Passable {
    Screen,
    Modal,
    Banner
}