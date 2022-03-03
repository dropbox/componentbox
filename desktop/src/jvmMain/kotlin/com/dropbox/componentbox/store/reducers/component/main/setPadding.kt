package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.models.Padding
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

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
            else -> {}
        }
    }
}