package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setFillMaxWidth(action: ComponentAction.ModifierAction.SetFillMaxWidth): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component.setFillMaxWidth(action.fillMaxWidth)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent.setFillMaxWidth(action.fillMaxWidth)
    }
}

private fun Component?.setFillMaxWidth(fillMaxWidth: Boolean): Component? {
    return apply {
        when (this) {
            is Component.Box -> modifier?.fillMaxWidth = fillMaxWidth
            is Component.Button -> modifier?.fillMaxWidth = fillMaxWidth
            is Component.Column -> modifier?.fillMaxWidth = fillMaxWidth
            is Component.Drawable -> modifier?.fillMaxWidth = fillMaxWidth
            is Component.Row -> modifier?.fillMaxWidth = fillMaxWidth
            is Component.Switch -> modifier?.fillMaxWidth = fillMaxWidth
            is Component.Text -> modifier?.fillMaxWidth = fillMaxWidth
            is Component.Vector -> modifier?.fillMaxWidth = fillMaxWidth
            else -> {}
        }
    }
}