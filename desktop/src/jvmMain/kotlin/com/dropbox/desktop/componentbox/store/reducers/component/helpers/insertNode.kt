package com.dropbox.desktop.componentbox.store.reducers.component.helpers

import com.dropbox.desktop.componentbox.data.entities.Node

internal fun MutableList<Node>.insertNode(node: Node, index: Int? = null) {
    if (index == null) {
        add(node)
    } else {
        add(index, node)
    }
}