package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.clearActiveNode(): ComponentState {
    return apply {
        activeNode = null
    }
}