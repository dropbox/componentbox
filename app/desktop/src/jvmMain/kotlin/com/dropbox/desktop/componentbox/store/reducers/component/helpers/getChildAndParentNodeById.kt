package com.dropbox.desktop.componentbox.store.reducers.component.helpers

import com.dropbox.desktop.componentbox.data.entities.ChildAndParentNode
import com.dropbox.desktop.componentbox.data.entities.Node

internal fun MutableList<Node>.getChildAndParentNodeById(id: String): ChildAndParentNode? {
    val queue = toMutableList()
        .map { rootNode -> ChildAndParentNode(child = rootNode, parent = null) }
        .toMutableList()

    while (queue.isNotEmpty()) {
        val current = queue.removeAt(0)
        if (current.child.id == id) return current
        val next = current.child.children
            .map { child -> ChildAndParentNode(child = child, parent = current.child) }
            .toMutableList()
        queue.addAll(next)
    }

    return null
}