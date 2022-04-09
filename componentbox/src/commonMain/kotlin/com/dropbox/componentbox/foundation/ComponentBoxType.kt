package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Serializable
enum class ComponentBoxType: Parcelable {
    Screen,
    Modal,
    Banner
}