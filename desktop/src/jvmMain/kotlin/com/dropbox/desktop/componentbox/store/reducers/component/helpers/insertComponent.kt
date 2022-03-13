package com.dropbox.desktop.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.foundation.Component

internal fun MutableList<Component>.insertComponent(component: Component, index: Int? = null) {
    if (index == null) {
        add(component)
    } else {
        add(index, component)
    }
}