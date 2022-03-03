package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

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
            else -> {}
        }
    }
}