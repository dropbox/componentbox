package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setFillMaxSize(action: ComponentAction.ModifierAction.SetFillMaxSize): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component.setFillMaxSize(action.fillMaxSize)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent.setFillMaxSize(action.fillMaxSize)
    }
}

private fun Component?.setFillMaxSize(fillMaxSize: Boolean): Component? {
    return apply {
        when (this) {
            is Component.Box -> modifier?.fillMaxSize = fillMaxSize
            is Component.Button -> modifier?.fillMaxSize = fillMaxSize
            is Component.Column -> modifier?.fillMaxSize = fillMaxSize
            is Component.Drawable -> modifier?.fillMaxSize = fillMaxSize
            is Component.Row -> modifier?.fillMaxSize = fillMaxSize
            is Component.Switch -> modifier?.fillMaxSize = fillMaxSize
            is Component.Text -> modifier?.fillMaxSize = fillMaxSize
            is Component.Vector -> modifier?.fillMaxSize = fillMaxSize
            is Component.Surface -> modifier?.fillMaxSize = fillMaxSize
            else -> {}
        }
    }
}