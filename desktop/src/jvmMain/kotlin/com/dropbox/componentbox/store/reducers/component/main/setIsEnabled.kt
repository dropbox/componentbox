package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setIsEnabled(action: ComponentAction.SetIsEnabled): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setIsEnabled(action.isEnabled)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setIsEnabled(action.isEnabled)
    }
}

private fun Component.setIsEnabled(isEnabled: Boolean): Component {
    return apply {
        when (this) {
            is Component.Button -> this.isEnabled = isEnabled
            else -> {}
        }
    }
}