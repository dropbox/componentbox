package com.dropbox.componentbox.store.subscriptions

import androidx.compose.runtime.MutableState
import com.dropbox.componentbox.store.state.AppState

fun syncScreenTitle(state: MutableState<String?>, appState: AppState) {
    state.value = appState.screenState.title
}