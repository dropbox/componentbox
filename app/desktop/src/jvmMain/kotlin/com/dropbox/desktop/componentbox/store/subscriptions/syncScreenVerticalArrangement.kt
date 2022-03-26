package com.dropbox.desktop.componentbox.store.subscriptions

import androidx.compose.runtime.MutableState
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.desktop.componentbox.store.state.AppState

fun syncScreenVerticalArrangement(state: MutableState<Arrangement>, appState: AppState) {
    state.value = appState.screenState.verticalArrangement
}