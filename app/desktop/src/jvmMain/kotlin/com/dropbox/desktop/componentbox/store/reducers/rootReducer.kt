package com.dropbox.desktop.componentbox.store.reducers

import com.dropbox.desktop.componentbox.store.reducers.component.componentReducer
import com.dropbox.desktop.componentbox.store.reducers.screen.screenReducer
import com.dropbox.desktop.componentbox.store.reducers.theme.themeReducer
import com.dropbox.desktop.componentbox.store.state.AppState

fun rootReducer(state: AppState, action: Any) = AppState(
    componentState = componentReducer(state.componentState, action),
    screenState = screenReducer(state.screenState, action),
    themeState = themeReducer(state.themeState, action)
)
