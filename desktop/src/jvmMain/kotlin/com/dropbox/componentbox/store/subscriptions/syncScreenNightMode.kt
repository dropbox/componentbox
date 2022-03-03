package com.dropbox.componentbox.store.subscriptions

import androidx.compose.runtime.MutableState
import com.dropbox.componentbox.store.state.AppState

fun syncScreenNightMode(state: MutableState<Boolean>, appState: AppState) {
    state.value = appState.screenState.isNightMode
}