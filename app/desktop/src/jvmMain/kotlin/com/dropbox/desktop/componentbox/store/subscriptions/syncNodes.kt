package com.dropbox.desktop.componentbox.store.subscriptions

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.desktop.componentbox.store.state.AppState

fun syncNodes(state: SnapshotStateList<Node>, appState: AppState) {
    state.clear()
    state.addAll(appState.componentState.nodes)
}
