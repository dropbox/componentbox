package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.clear(): ComponentState {
    return apply {
        idToComponent = mutableMapOf()
        nodes = mutableListOf()
        rootComponents = mutableListOf()
        activeNode = null
    }
}