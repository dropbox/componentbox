package com.dropbox.desktop.componentbox.store.subscriptions

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.dropbox.componentbox.foundation.Component
import com.dropbox.desktop.componentbox.store.state.AppState

fun syncComponents(state: SnapshotStateList<Component>, appState: AppState) {
    state.clear()
    state.addAll(appState.componentState.rootComponents)
}