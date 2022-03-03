package com.dropbox.componentbox.store.subscriptions

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.store.state.AppState

fun syncComponents(state: SnapshotStateList<Component>, appState: AppState) {
    state.clear()
    state.addAll(appState.componentState.rootComponents)
}