package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setText(action: ComponentAction.SetText): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setText(action.text)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setText(action.text)
    }
}

private fun Component.setText(text: String): Component {
    return apply {
        when (this) {
            is Component.Text -> this.text = text
            else -> {}
        }
    }
}