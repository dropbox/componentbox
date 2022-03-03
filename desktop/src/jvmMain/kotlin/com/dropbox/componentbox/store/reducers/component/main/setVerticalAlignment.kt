package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.models.Alignment
import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setVerticalAlignment(action: ComponentAction.LayoutAction.SetVerticalAlignment): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setVerticalAlignment(action.verticalAlignment)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setVerticalAlignment(action.verticalAlignment)
    }
}

private fun Component.setVerticalAlignment(verticalAlignment: Alignment): Component {
    return apply {
        when (this) {
            is Component.Box -> this.verticalAlignment = verticalAlignment
            is Component.Row -> this.verticalAlignment = verticalAlignment
            else -> {}
        }
    }
}