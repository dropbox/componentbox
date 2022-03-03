package com.dropbox.componentbox.store.subscriptions

import androidx.compose.runtime.MutableState
import com.dropbox.componentbox.models.Arrangement
import com.dropbox.componentbox.store.state.AppState

fun syncScreenVerticalArrangement(state: MutableState<Arrangement>, appState: AppState) {
    state.value = appState.screenState.verticalArrangement
}