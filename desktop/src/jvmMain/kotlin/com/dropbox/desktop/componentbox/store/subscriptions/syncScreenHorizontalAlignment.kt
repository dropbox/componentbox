package com.dropbox.desktop.componentbox.store.subscriptions

import androidx.compose.runtime.MutableState
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.desktop.componentbox.store.state.AppState

fun syncScreenHorizontalAlignment(state: MutableState<Alignment>, appState: AppState) {
    state.value = appState.screenState.horizontalAlignment
}