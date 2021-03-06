package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setAction(action: ComponentAction.SetAction): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setAction(action.action)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setAction(action.action)
    }
}

private fun Component.setAction(action: String): Component {
    return apply {
        when (this) {
            is Component.Box -> this.action = action
            is Component.Button -> this.action = action
            is Component.Column -> this.action = action
            is Component.Row -> this.action = action
            is Component.Switch -> this.action = action
            else -> {}
        }
    }
}