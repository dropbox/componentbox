package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Padding
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setPadding(action: ComponentAction.ModifierAction.SetPadding): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component.setPadding(action.padding)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent.setPadding(action.padding)
    }
}

private fun Component?.setPadding(padding: Padding): Component? {
    return apply {
        when (this) {
            is Component.Box -> modifier?.padding = padding
            is Component.Button -> modifier?.padding = padding
            is Component.Column -> modifier?.padding = padding
            is Component.Drawable -> modifier?.padding = padding
            is Component.Row -> modifier?.padding = padding
            is Component.Switch -> modifier?.padding = padding
            is Component.Text -> modifier?.padding = padding
            is Component.Vector -> modifier?.padding = padding
            is Component.Surface -> modifier?.padding = padding
            else -> {}
        }
    }
}