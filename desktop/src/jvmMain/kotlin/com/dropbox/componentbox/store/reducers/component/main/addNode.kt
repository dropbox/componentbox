package com.dropbox.componentbox.store.reducers.component.main

import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.reducers.component.helpers.build
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentById
import com.dropbox.componentbox.store.reducers.component.helpers.getComponentChildren
import com.dropbox.componentbox.store.reducers.component.helpers.getNodeById
import com.dropbox.componentbox.store.reducers.component.helpers.insertComponent
import com.dropbox.componentbox.store.reducers.component.helpers.insertNode
import com.dropbox.componentbox.store.reducers.component.helpers.setComponentChildren
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentState.addNode(action: ComponentAction.AddNode): ComponentState {
    return apply {
        val component = action.node.type.build(action.node.id)

        if (action.parentId == null) {
            nodes.insertNode(action.node, action.index)
            rootComponents.insertComponent(component)
        } else {
            val parentNode = nodes.getNodeById(action.parentId)
            parentNode?.children?.insertNode(action.node, action.index)

            val parentComponent = rootComponents.getComponentById(action.parentId)
            val nextChildren = parentComponent?.getComponentChildren()
            if (nextChildren != null) {
                nextChildren.insertComponent(component, action.index)
                parentComponent.setComponentChildren(nextChildren)
            } else {
                parentComponent.setComponentChildren(mutableListOf(component))
            }
        }

        idToComponent[action.node.id] = component
    }
}