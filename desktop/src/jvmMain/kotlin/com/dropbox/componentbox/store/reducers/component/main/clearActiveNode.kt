package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.clearActiveNode(): ComponentState {
    return apply {
        activeNode = null
    }
}