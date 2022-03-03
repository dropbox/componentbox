package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.models.Component

internal fun MutableList<Component>.insertComponent(component: Component, index: Int? = null) {
    if (index == null) {
        add(component)
    } else {
        add(index, component)
    }
}