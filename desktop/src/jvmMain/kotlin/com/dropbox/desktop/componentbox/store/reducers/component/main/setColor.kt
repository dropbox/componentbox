package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setColor(action: ComponentAction.SetColor): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setColor(action.color)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setColor(action.color)
    }
}

private fun Component.setColor(color: String): Component {
    return apply {
        when (this) {
            is Component.Text -> this.color = color
            is Component.Vector -> this.color = color
            else -> {}
        }
    }
}