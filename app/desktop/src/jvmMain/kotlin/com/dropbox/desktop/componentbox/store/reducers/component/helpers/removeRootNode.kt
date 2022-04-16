package com.dropbox.desktop.componentbox.store.reducers.component.helpers

import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.removeRootNode(node: Node): ComponentState {
    return apply {
        nodes = nodes
            .filter { it.id != node.id }
            .toMutableList()
    }
}