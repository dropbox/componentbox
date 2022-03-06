package com.dropbox.componentbox.models

import kotlinx.serialization.Serializable

@Serializable
enum class ComponentBoxType {
    Screen,
    Modal,
    Banner
}