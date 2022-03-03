package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setActiveNode(action: ComponentAction.SetActiveNode): ComponentState {
    return apply {
        activeNode = action.node.copy()
    }
}