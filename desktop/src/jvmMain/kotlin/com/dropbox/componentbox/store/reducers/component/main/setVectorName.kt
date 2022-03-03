package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setVectorName(action: ComponentAction.SetVectorName): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setVectorName(action.name)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setVectorName(action.name)
    }
}

private fun Component.setVectorName(name: String): Component {
    return apply {
        when (this) {
            is Component.Vector -> this.name = name
            else -> {}
        }
    }
}