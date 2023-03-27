package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable


sealed interface Trail<T : Tree> : ComponentBox {
    var root: Node<T>?
    val nodes: MutableList<Node<T>>

    interface Node<T : Tree> : Tree {
        val value: T
        var parent: Node<T>?
        var child: Node<T>?
        var prev: Node<T>?
        var next: Node<T>?
    }


    @Serializable
    data class Static(
        override var root: Node<Tree.Static>? = null,
        override val nodes: MutableList<Node<Tree.Static>> = mutableListOf(root).filterNotNull().toMutableList()
    ) : Trail<Tree.Static> {
        fun node(node: Node<Tree.Static>) {
            if (root == null) {
                root = node
                nodes.add(node)
                return
            }

            val last = nodes.last()
            last.next = node
            node.prev = last
            nodes.add(node)
        }
    }

    interface Dynamic : Trail<Tree.Dynamic> {
        @Composable
        fun node(tree: Tree.Dynamic)
    }

}

data class DynamicTrail(
    override var root: Trail.Node<Tree.Dynamic>? = null,
    override val nodes: MutableList<Trail.Node<Tree.Dynamic>> = mutableListOf(root).filterNotNull().toMutableList()
) : Trail.Dynamic {
    @Composable
    override fun node(tree: Tree.Dynamic) {
        val node = TrailNode(tree)

        if (root == null) {
            root = node
            nodes.add(node)
            return
        }

        val last = nodes.last()
        last.next = node
        node.prev = last
        nodes.add(node)
    }
}

data class TrailNode<T : Tree>(
    override val value: T,
    override var parent: Trail.Node<T>? = null,
    override var child: Trail.Node<T>? = null,
    override var prev: Trail.Node<T>? = null,
    override var next: Trail.Node<T>? = null
) : Trail.Node<T>