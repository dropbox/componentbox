package com.dropbox.desktop.componentbox.store.reducers.component.helpers

import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.removeNodeAndDescendentsFromMap(node: Node): ComponentState {
    return apply {
        val queue = mutableListOf(node)
        while (queue.isNotEmpty()) {
            val current = queue.removeAt(0)
            idToComponent.remove(current.id)
            queue.addAll(current.children)
        }
    }
}