package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.removeChildFromParentComponent(child: Component, parent: Component): ComponentState {
    return apply {
        val nextChildren = parent
            .getComponentChildren()
            ?.filter { it.componentId() != child.componentId() }
            ?.toMutableList()

        if (nextChildren != null) {
            parent.setComponentChildren(nextChildren)
        }
    }
}