package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.removeChildFromParentNode(child: Node, parent: Node): ComponentState {
    return apply {
        parent.children = parent.children
            .filter { it.id != child.id }
            .toMutableList()
    }
}
