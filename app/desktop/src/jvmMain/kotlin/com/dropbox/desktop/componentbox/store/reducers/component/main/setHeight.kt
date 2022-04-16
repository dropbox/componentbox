package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setHeight(action: ComponentAction.ModifierAction.SetHeight): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component.setHeight(action.height)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent.setHeight(action.height)
    }
}

private fun Component?.setHeight(height: Int): Component? {
    return apply {
        when (this) {
            is Component.Box -> modifier?.height = height
            is Component.Button -> modifier?.height = height
            is Component.Column -> modifier?.height = height
            is Component.Drawable -> modifier?.height = height
            is Component.Row -> modifier?.height = height
            is Component.Switch -> modifier?.height = height
            is Component.Text -> modifier?.height = height
            is Component.Vector -> modifier?.height = height
            is Component.Surface -> modifier?.height = height
            else -> {}
        }
    }
}