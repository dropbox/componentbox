package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable


sealed interface Forest<T : Tree> : ComponentBox {
    val start: TreeId
    val trees: MutableMap<TreeId, T>

    @Serializable
    class Static(
        override val start: TreeId,
        override val trees: MutableMap<TreeId, Tree.Static> = mutableMapOf()
    ) : Forest<Tree.Static> {
        fun tree(id: TreeId, tree: Tree.Static) {
            trees[id] = tree
        }
    }

    interface Dynamic : Forest<Tree.Dynamic> {
        @Composable
        fun tree(id: TreeId, tree: Tree.Dynamic)
    }
}

data class DynamicForest(
    override val start: TreeId,
    override val trees: MutableMap<TreeId, Tree.Dynamic> = mutableMapOf()
) : Forest.Dynamic {

    @Composable
    override fun tree(id: TreeId, tree: Tree.Dynamic) {
        trees[id] = tree
    }
}