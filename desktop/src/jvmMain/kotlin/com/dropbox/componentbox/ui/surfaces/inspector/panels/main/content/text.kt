package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.componentbox.ui.surfaces.inspector.panels.textInput

@Composable
fun text() {
    val activeNode = remember { mutableStateOf(store.state.componentState.activeNode) }
    val state = remember { mutableStateOf("") }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    textInput(state, LABEL) { input ->
        state.value = input

        if (activeNode.value != null) {
            store.dispatch(
                ComponentAction.SetText(
                    id = activeNode.value!!.id,
                    text = input
                )
            )
        }
    }
}

private const val LABEL = "Text:"