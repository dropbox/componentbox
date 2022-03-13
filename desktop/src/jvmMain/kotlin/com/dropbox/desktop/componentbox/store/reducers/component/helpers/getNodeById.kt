package com.dropbox.desktop.componentbox.store.reducers.component.helpers

import com.dropbox.desktop.componentbox.data.entities.Node

internal fun MutableList<Node>.getNodeById(id: String): Node? {
    val copy = toMutableList()
    while (copy.isNotEmpty()) {
        val node = copy.removeAt(0)
        if (node.id == id) return node
        copy.addAll(node.children)
    }
    return null
}