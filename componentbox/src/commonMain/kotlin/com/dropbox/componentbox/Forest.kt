package com.dropbox.componentbox

import kotlinx.serialization.Serializable


sealed interface Forest : ComponentBox {
    @Serializable
    data class Static(
        val start: TreeId,
        val trees: MutableMap<TreeId, Tree.Static> = mutableMapOf()
    ) : Forest {
        fun tree(id: TreeId, tree: Tree.Static) {
            trees[id] = tree
        }

        fun get(id: TreeId): Tree? = trees[id]
        fun remove(id: TreeId) = trees.remove(id)
    }

    data class Dynamic(
        val start: TreeId,
        val trees: MutableMap<TreeId, Tree.Dynamic> = mutableMapOf()
    ) : Forest {
        fun tree(id: TreeId, tree: Tree.Dynamic) {
            trees[id] = tree
        }

        fun get(id: TreeId): Tree? = trees[id]
        fun remove(id: TreeId) = trees.remove(id)
    }
}