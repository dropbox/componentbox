package com.dropbox.componentbox.store.subscriptions

import androidx.compose.runtime.MutableState
import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.store.state.AppState

fun syncActiveNode(state: MutableState<Node?>, appState: AppState) {
    state.value = appState.componentState.activeNode
}
