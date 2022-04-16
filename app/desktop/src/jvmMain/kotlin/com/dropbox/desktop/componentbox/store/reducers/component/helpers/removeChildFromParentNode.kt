package com.dropbox.desktop.componentbox.store.reducers.component.helpers

import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.removeChildFromParentNode(child: Node, parent: Node): ComponentState {
    return apply {
        parent.children = parent.children
            .filter { it.id != child.id }
            .toMutableList()
    }
}
