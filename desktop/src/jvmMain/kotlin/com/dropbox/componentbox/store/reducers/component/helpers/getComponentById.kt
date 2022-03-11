package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.foundation.Component

internal fun MutableList<Component>.getComponentById(id: String): Component? {
    val copy = toMutableList()
    while (copy.size > 0) {
        val component = copy.removeAt(0)
        val componentId = component.componentId()
        if (componentId == id) return component
        val children = component.getComponentChildren()
        if (children != null) {
            copy.addAll(children)
        }
    }
    return null
}