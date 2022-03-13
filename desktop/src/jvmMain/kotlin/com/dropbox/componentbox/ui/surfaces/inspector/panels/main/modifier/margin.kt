package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.modifier

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Margin
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.utils.getComponentById
import com.dropbox.componentbox.utils.margin

@Composable
fun margin() {
    paddingGroup("Margin") { change, nodeId ->
        val activeComponent = store.state.componentState.getComponentById(nodeId)
        if (activeComponent != null) {
            store.dispatch(
                ComponentAction.ModifierAction.SetMargin(
                    nodeId,
                    activeComponent.margin().build(change)
                )
            )
        }
    }
}

private fun Margin.build(change: Change) = when (change.type) {
    Type.Start -> copy(start = change.value)
    Type.Top -> copy(top = change.value)
    Type.End -> copy(end = change.value)
    Type.Bottom -> copy(bottom = change.value)
}

