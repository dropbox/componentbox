package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Component
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

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