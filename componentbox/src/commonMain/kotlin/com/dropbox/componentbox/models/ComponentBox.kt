package com.dropbox.componentbox.models

import kotlinx.serialization.Serializable

@Serializable
sealed class ComponentBox {
    @Serializable
    data class Screen(
        val title: String?,
        val verticalArrangement: Arrangement,
        val horizontalAlignment: Alignment,
        val components: List<Component>
    ) : ComponentBox()

    @Serializable
    data class Modal(
        val verticalArrangement: Arrangement,
        val horizontalAlignment: Alignment,
        val components: List<Component>
    ) : ComponentBox()

    @Serializable
    data class HorizontalBanner(
        val verticalArrangement: Arrangement,
        val horizontalAlignment: Alignment,
        val components: List<Component>
    ) : ComponentBox()
}