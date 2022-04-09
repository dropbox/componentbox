package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Parcelize
@Serializable
sealed class ComponentBox: Parcelable {
    @Parcelize
    @Serializable
    data class Screen(
        val title: String?,
        val verticalArrangement: Arrangement,
        val horizontalAlignment: Alignment,
        val components: List<Component>
    ) : ComponentBox(), Parcelable

    @Parcelize
    @Serializable
    data class Modal(
        val verticalArrangement: Arrangement,
        val horizontalAlignment: Alignment,
        val components: List<Component>
    ) : ComponentBox(), Parcelable

    @Parcelize
    @Serializable
    data class Banner(
        val verticalArrangement: Arrangement,
        val horizontalAlignment: Alignment,
        val components: List<Component>
    ) : ComponentBox(), Parcelable
}