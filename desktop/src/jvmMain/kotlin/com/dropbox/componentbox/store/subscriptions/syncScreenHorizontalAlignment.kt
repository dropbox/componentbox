package com.dropbox.componentbox.store.subscriptions

import androidx.compose.runtime.MutableState
import com.dropbox.componentbox.models.Alignment
import com.dropbox.componentbox.store.state.AppState

fun syncScreenHorizontalAlignment(state: MutableState<Alignment>, appState: AppState) {
    state.value = appState.screenState.horizontalAlignment
}