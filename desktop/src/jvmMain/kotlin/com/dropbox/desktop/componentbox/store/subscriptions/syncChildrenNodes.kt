package com.dropbox.desktop.componentbox.store.subscriptions

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.desktop.componentbox.store.state.AppState

fun syncChildrenNodes(state: SnapshotStateList<Node>, appState: AppState) {
    val children = appState.componentState.activeNode?.children
    if (children != null && children.isNotEmpty()) {
        state.clear()
        state.addAll(children)
    }
}
