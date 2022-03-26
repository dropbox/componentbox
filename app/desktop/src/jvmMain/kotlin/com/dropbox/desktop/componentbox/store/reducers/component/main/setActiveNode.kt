package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setActiveNode(action: ComponentAction.SetActiveNode): ComponentState {
    return apply {
        activeNode = action.node.copy()
    }
}