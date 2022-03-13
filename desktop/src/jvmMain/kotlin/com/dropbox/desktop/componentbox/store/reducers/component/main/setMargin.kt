package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Margin
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setMargin(action: ComponentAction.ModifierAction.SetMargin): ComponentState {
    return apply {
        val nextIdToComponent = idToComponent.toMutableMap()
        nextIdToComponent[action.id].setMargin(action.margin)

        val nextRootComponents = rootComponents.toMutableList()
        nextRootComponents.getComponentById(action.id).setMargin(action.margin)

        this.idToComponent = nextIdToComponent
        rootComponents = nextRootComponents
    }
}

private fun Component?.setMargin(margin: Margin): Component? {
    return apply {
        when (this) {
            is Component.Box -> modifier?.margin = margin.copy()
            is Component.Button -> modifier?.margin = margin.copy()
            is Component.Column -> modifier?.margin = margin.copy()
            is Component.Drawable -> modifier?.margin = margin.copy()
            is Component.Row -> modifier?.margin = margin.copy()
            is Component.Switch -> modifier?.margin = margin.copy()
            is Component.Text -> modifier?.margin = margin.copy()
            is Component.Vector -> modifier?.margin = margin.copy()
            is Component.Surface -> modifier?.margin = margin.copy()
            else -> {}
        }
    }
}