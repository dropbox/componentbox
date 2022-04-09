package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Parcelize
@Serializable
enum class ButtonVariant: Parcelable {
    Contained,
    Text,
    Outlined,
    Icon
}