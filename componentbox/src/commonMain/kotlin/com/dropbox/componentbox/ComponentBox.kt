package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

sealed interface ComponentBox {
    @Serializable
    data class Static(
        val root: Tree
    ) : ComponentBox

    interface Dynamic : ComponentBox {
        val root: Tree
            @Composable get
    }
}


fun componentBox(tree: () -> Tree): ComponentBox.Static = ComponentBox.Static(tree())

@Composable
fun ComponentBox(tree: @Composable () -> Tree): ComponentBox.Dynamic = object : ComponentBox.Dynamic {
    override val root: Tree
        @Composable get() = tree()
}