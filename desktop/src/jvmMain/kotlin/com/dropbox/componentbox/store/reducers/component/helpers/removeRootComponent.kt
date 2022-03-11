package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.removeRootComponent(component: Component): ComponentState {
    return apply {
        rootComponents = rootComponents
            .filter { it.componentId() != component.componentId() }
            .toMutableList()
    }
}