package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setDrawableName(action: ComponentAction.SetDrawableName): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setDrawableName(action.name)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setDrawableName(action.name)
    }
}

private fun Component.setDrawableName(name: String): Component {
    return apply {
        when (this) {
            is Component.Drawable -> this.name = name
            else -> {}
        }
    }
}