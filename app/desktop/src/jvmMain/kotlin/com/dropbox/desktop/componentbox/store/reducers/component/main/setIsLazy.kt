package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setIsLazy(action: ComponentAction.SetIsLazy): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setIsLazy(action.isLazy)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setIsLazy(action.isLazy)
    }
}

private fun Component.setIsLazy(isLazy: Boolean): Component {
    return apply {
        when (this) {
            is Component.Column -> this.isLazy = isLazy
            is Component.Row -> this.isLazy = isLazy
            else -> {}
        }
    }
}