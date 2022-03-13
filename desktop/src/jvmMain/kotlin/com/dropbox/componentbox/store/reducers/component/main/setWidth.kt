package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setWidth(action: ComponentAction.ModifierAction.SetWidth): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component.setWidth(action.width)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent.setWidth(action.width)
    }
}

private fun Component?.setWidth(width: Int): Component? {
    return apply {
        when (this) {
            is Component.Box -> modifier?.width = width
            is Component.Button -> modifier?.width = width
            is Component.Column -> modifier?.width = width
            is Component.Drawable -> modifier?.width = width
            is Component.Row -> modifier?.width = width
            is Component.Switch -> modifier?.width = width
            is Component.Text -> modifier?.width = width
            is Component.Vector -> modifier?.width = width
            is Component.Surface -> modifier?.width = width
            else -> {}
        }
    }
}