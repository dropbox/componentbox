package com.dropbox.componentbox.store.subscriptions

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.store.state.AppState

fun syncNodes(state: SnapshotStateList<Node>, appState: AppState) {
    state.clear()
    state.addAll(appState.componentState.nodes)
}
