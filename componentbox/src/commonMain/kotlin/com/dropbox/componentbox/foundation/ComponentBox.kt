package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Serializable
sealed class ComponentBox: Passable {
    @IsPassable
    @Serializable
    data class Screen(
        val title: String?,
        val verticalArrangement: Arrangement,
        val horizontalAlignment: Alignment,
        val components: List<Component>
    ) : ComponentBox(), Passable

    @IsPassable
    @Serializable
    data class Modal(
        val verticalArrangement: Arrangement,
        val horizontalAlignment: Alignment,
        val components: List<Component>
    ) : ComponentBox(), Passable

    @IsPassable
    @Serializable
    data class Banner(
        val verticalArrangement: Arrangement,
        val horizontalAlignment: Alignment,
        val components: List<Component>
    ) : ComponentBox(), Passable
}