package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.ContentScale
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.setContentScale(action: ComponentAction.SetContentScale): ComponentState {
    return apply {
        val component = idToComponent[action.id]
        component?.setContentScale(action.contentScale)

        val rootComponent = rootComponents.getComponentById(action.id)
        rootComponent?.setContentScale(action.contentScale)
    }
}

private fun Component.setContentScale(contentScale: ContentScale): Component {
    return apply {
        when (this) {
            is Component.Drawable -> this.contentScale = contentScale
            is Component.Vector -> this.contentScale = contentScale
            else -> {}
        }
    }
}