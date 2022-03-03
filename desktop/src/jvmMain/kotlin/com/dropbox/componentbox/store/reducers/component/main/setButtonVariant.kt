package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setButtonVariant(action: ComponentAction.SetButtonVariant): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setVariant(action.variant)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setVariant(action.variant)
    }
}

private fun Component.setVariant(variant: String): Component {
    return apply {
        if (this is Component.Button) {
            this.variant = variant
        }
    }
}