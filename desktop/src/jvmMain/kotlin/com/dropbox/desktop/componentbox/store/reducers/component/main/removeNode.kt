package com.dropbox.desktop.componentbox.store.reducers.component.main

import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getChildAndParentComponentById
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.getChildAndParentNodeById
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.removeChildFromParentComponent
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.removeChildFromParentNode
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.removeNodeAndDescendentsFromMap
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.removeRootComponent
import com.dropbox.desktop.componentbox.store.reducers.component.helpers.removeRootNode
import com.dropbox.desktop.componentbox.store.state.ComponentState

internal fun ComponentState.removeNode(action: ComponentAction.RemoveNode): ComponentState {
    return apply {
        val childAndParentNode = nodes.getChildAndParentNodeById(action.id)
        if (childAndParentNode?.child != null) {
            removeNodeAndDescendentsFromMap(childAndParentNode.child)

            if (childAndParentNode.parent != null) {
                removeChildFromParentNode(
                    childAndParentNode.child,
                    childAndParentNode.parent
                )
            } else removeRootNode(childAndParentNode.child)
        }

        val childAndParentComponent = rootComponents.getChildAndParentComponentById(action.id)
        if (childAndParentComponent?.child != null) {
            if (childAndParentComponent.parent != null) {
                removeChildFromParentComponent(
                    childAndParentComponent.child,
                    childAndParentComponent.parent
                )
            } else removeRootComponent(childAndParentComponent.child)
        }
    }
}







