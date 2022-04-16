package com.dropbox.desktop.componentbox.store.subscriptions

import androidx.compose.runtime.MutableState
import com.dropbox.desktop.componentbox.store.state.AppState

fun syncBottomTabs(state: MutableState<Boolean>, appState: AppState) {
    state.value = appState.screenState.showBottomTabs
}