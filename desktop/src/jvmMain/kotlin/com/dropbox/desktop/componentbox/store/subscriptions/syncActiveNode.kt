package com.dropbox.desktop.componentbox.store.subscriptions

import androidx.compose.runtime.MutableState
import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.desktop.componentbox.store.state.AppState

fun syncActiveNode(state: MutableState<Node?>, appState: AppState) {
    state.value = appState.componentState.activeNode
}
