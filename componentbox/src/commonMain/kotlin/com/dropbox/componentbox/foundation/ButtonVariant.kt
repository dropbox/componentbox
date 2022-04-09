package com.dropbox.componentbox.foundation


@kotlinx.serialization.Serializable
enum class ButtonVariant: Parcelable {
    Contained,
    Text,
    Outlined,
    Icon
}