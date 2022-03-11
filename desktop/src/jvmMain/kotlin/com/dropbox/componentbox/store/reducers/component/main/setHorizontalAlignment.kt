package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setHorizontalAlignment(action: ComponentAction.LayoutAction.SetHorizontalAlignment): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setHorizontalAlignment(action.horizontalAlignment)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setHorizontalAlignment(action.horizontalAlignment)
    }
}

private fun Component.setHorizontalAlignment(horizontalAlignment: Alignment): Component {
    return apply {
        when (this) {
            is Component.Column -> this.horizontalAlignment = horizontalAlignment
            else -> {}
        }
    }
}