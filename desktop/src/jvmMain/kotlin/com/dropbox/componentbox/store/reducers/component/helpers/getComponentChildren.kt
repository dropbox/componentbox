package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.foundation.Component

internal fun Component.getComponentChildren(): MutableList<Component>? {
    return let { component ->
        when (component) {
            is Component.Box -> component.components
            is Component.Button -> component.components
            is Component.Column -> component.components
            is Component.Row -> component.components
            else -> null
        }
    }
}