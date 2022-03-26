package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Component
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setHorizontalArrangement(action: ComponentAction.LayoutAction.SetHorizontalArrangement): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setHorizontalArrangement(action.horizontalArrangement)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setHorizontalArrangement(action.horizontalArrangement)
    }
}

private fun Component.setHorizontalArrangement(horizontalArrangement: Arrangement): Component {
    return apply {
        when (this) {
            is Component.Box -> this.horizontalArrangement = horizontalArrangement
            is Component.Row -> this.horizontalArrangement = horizontalArrangement
            else -> {}
        }
    }
}