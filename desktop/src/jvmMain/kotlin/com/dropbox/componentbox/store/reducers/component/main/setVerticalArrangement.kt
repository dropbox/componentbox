package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setVerticalArrangement(action: ComponentAction.LayoutAction.SetVerticalArrangement): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setVerticalArrangement(action.verticalArrangement)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setVerticalArrangement(action.verticalArrangement)
    }
}

private fun Component.setVerticalArrangement(verticalArrangement: Arrangement): Component {
    return apply {
        when (this) {
            is Component.Column -> this.verticalArrangement = verticalArrangement
            else -> {}
        }
    }
}