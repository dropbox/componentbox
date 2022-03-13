package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.setModifier(action: ComponentAction.ModifierAction.SetModifier): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setModifier(action.modifier)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setModifier(action.modifier)
    }
}

private fun Component.setModifier(modifier: Modifier): Component {
    return apply {
        when (this) {
            is Component.Box -> this.modifier = modifier
            is Component.Button -> this.modifier = modifier
            is Component.Column -> this.modifier = modifier
            is Component.Drawable -> this.modifier = modifier
            is Component.Row -> this.modifier = modifier
            is Component.Switch -> this.modifier = modifier
            is Component.Text -> this.modifier = modifier
            is Component.Vector -> this.modifier = modifier
            is Component.Surface -> this.modifier = modifier
        }
    }
}