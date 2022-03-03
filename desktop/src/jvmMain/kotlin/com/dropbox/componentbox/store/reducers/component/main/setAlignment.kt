package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.models.Alignment
import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setAlignment(action: ComponentAction.LayoutAction.SetAlignment): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component.setAlignment(action.alignment)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent.setAlignment(action.alignment)
    }
}

private fun Component?.setAlignment(alignment: Alignment): Component? {
    return apply {
        when (this) {
            is Component.Drawable -> this.alignment = alignment
            is Component.Vector -> this.alignment = alignment
            else -> {}
        }
    }
}