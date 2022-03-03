package com.dropbox.componentbox.store.subscriptions

import androidx.compose.runtime.MutableState
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.store.state.AppState

fun syncScreenHeight(state: MutableState<Dp>, appState: AppState) =
    if (appState.screenState.showBottomTabs) state.value = 550.dp else state.value = 620.dp