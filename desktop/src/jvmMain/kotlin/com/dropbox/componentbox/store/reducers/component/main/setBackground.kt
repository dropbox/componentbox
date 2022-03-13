package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setBackground(action: ComponentAction.ModifierAction.SetBackground): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component.setBackground(action.background)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent.setBackground(action.background)
    }
}

private fun Component?.setBackground(background: String): Component? {
    return apply {
        when (this) {
            is Component.Box -> modifier?.background = background
            is Component.Button -> modifier?.background = background
            is Component.Column -> modifier?.background = background
            is Component.Drawable -> modifier?.background = background
            is Component.Row -> modifier?.background = background
            is Component.Switch -> modifier?.background = background
            is Component.Text -> modifier?.background = background
            is Component.Vector -> modifier?.background = background
            is Component.Surface -> modifier?.background = background
            else -> {}
        }
    }
}