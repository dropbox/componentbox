package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.data.entities.ChildAndParentComponent
import com.dropbox.componentbox.foundation.Component

internal fun MutableList<Component>.getChildAndParentComponentById(id: String): ChildAndParentComponent? {
    val queue = toMutableList()
        .map { rootComponent -> ChildAndParentComponent(child = rootComponent, parent = null) }
        .toMutableList()

    while (queue.isNotEmpty()) {
        val current = queue.removeAt(0)
        if (current.child.componentId() == id) return current

        val next = current.child
            .getComponentChildren()
            ?.map { ChildAndParentComponent(child = it, parent = current.child) }
            ?.toMutableList()
        if (next != null) {
            queue.addAll(next)
        }
    }

    return null
}