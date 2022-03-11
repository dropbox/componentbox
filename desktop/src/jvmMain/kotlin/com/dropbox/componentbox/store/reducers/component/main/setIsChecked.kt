package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setIsChecked(action: ComponentAction.SetIsChecked): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setIsChecked(action.isChecked)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setIsChecked(action.isChecked)
    }
}

private fun Component.setIsChecked(isChecked: Boolean): Component {
    return apply {
        when (this) {
            is Component.Switch -> this.isChecked = isChecked
            else -> {}
        }
    }
}