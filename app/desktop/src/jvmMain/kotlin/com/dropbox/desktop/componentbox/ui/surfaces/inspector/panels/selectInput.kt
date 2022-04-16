package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.store.subscriptions.syncActiveNode

@Composable
fun <T> selectInput(label: String, options: List<T>, dispatch: (id: String, selection: T) -> Any) {
    val activeNode = remember { mutableStateOf(store.state.componentState.activeNode) }
    val state = remember { mutableStateOf<T?>(null) }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    select(state, label, options) { selection ->
        state.value = selection
        if (activeNode.value != null) {
            store.dispatch(dispatch(activeNode.value!!.id, selection))
        }
    }
}