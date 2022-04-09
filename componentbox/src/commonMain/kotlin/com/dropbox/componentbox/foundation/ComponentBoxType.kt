package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Parcelize
@Serializable
enum class ComponentBoxType: Parcelable {
    Screen,
    Modal,
    Banner
}