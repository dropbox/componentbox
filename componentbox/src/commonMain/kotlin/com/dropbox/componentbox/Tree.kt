package com.dropbox.componentbox

import kotlinx.serialization.Serializable

interface Tree : ComponentBox {
    @Serializable
    data class Static(
        val root: Component
    ) : Tree

    data class Dynamic(
        val root: Component
    ) : Tree
}
