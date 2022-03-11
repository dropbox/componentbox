package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setTextStyle(action: ComponentAction.SetTextStyle): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setTextStyle(action.style)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setTextStyle(action.style)
    }
}

private fun Component.setTextStyle(style: String): Component {
    return apply {
        when (this) {
            is Component.Text -> this.textStyle = style
            else -> {}
        }
    }
}