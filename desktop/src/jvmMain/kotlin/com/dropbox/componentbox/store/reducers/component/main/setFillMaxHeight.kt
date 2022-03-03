package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setFillMaxHeight(action: ComponentAction.ModifierAction.SetFillMaxHeight): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component.setFillMaxHeight(action.fillMaxHeight)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent.setFillMaxHeight(action.fillMaxHeight)
    }
}

private fun Component?.setFillMaxHeight(fillMaxHeight: Boolean): Component? {
    return apply {
        when (this) {
            is Component.Box -> modifier?.fillMaxHeight = fillMaxHeight
            is Component.Button -> modifier?.fillMaxHeight = fillMaxHeight
            is Component.Column -> modifier?.fillMaxHeight = fillMaxHeight
            is Component.Drawable -> modifier?.fillMaxHeight = fillMaxHeight
            is Component.Row -> modifier?.fillMaxHeight = fillMaxHeight
            is Component.Switch -> modifier?.fillMaxHeight = fillMaxHeight
            is Component.Text -> modifier?.fillMaxHeight = fillMaxHeight
            is Component.Vector -> modifier?.fillMaxHeight = fillMaxHeight
            else -> {}
        }
    }
}