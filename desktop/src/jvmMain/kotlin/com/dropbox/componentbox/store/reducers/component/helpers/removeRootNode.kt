package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.removeRootNode(node: Node): ComponentState {
    return apply {
        nodes = nodes
            .filter { it.id != node.id }
            .toMutableList()
    }
}