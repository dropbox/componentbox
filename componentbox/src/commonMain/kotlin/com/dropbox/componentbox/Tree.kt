package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * A container of a root component.
 * Represents the hierarchical structure of UI components. For example, a screen.
 */
interface Tree : ComponentBox {
    @Serializable
    data class Static(
        val root: Component
    ) : Tree

    data class Dynamic(
        val root: Component
    ) : Tree
}
