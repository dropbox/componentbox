package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.modifier

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Padding
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.util.getComponentById
import com.dropbox.desktop.componentbox.util.padding

@Composable
fun padding() {
    paddingGroup("Padding") { change, nodeId ->
        val activeComponent = store.state.componentState.getComponentById(nodeId)
        if (activeComponent != null) {
            store.dispatch(
                ComponentAction.ModifierAction.SetPadding(
                    nodeId,
                    activeComponent.padding().build(change)
                )
            )
        }
    }
}

private fun Padding.build(change: Change) = when (change.type) {
    Type.Start -> copy(start = change.value)
    Type.Top -> copy(top = change.value)
    Type.End -> copy(end = change.value)
    Type.Bottom -> copy(bottom = change.value)
}

