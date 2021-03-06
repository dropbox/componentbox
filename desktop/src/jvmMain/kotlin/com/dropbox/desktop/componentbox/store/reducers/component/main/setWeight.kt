package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setWeight(action: ComponentAction.ModifierAction.SetWeight): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component.setWeight(action.weight)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent.setWeight(action.weight)
    }
}

private fun Component?.setWeight(weight: Float): Component? {
    return apply {
        when (this) {
            is Component.Box -> modifier?.weight = weight
            is Component.Button -> modifier?.weight = weight
            is Component.Column -> modifier?.weight = weight
            is Component.Drawable -> modifier?.weight = weight
            is Component.Row -> modifier?.weight = weight
            is Component.Switch -> modifier?.weight = weight
            is Component.Text -> modifier?.weight = weight
            is Component.Vector -> modifier?.weight = weight
            is Component.Surface -> modifier?.weight = weight
            else -> {}
        }
    }
}