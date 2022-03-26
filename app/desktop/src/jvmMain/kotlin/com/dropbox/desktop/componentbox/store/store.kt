package com.dropbox.desktop.componentbox.store

import com.dropbox.desktop.componentbox.store.reducers.rootReducer
import com.dropbox.desktop.componentbox.store.state.AppState
import com.dropbox.desktop.componentbox.store.state.ComponentState
import com.dropbox.desktop.componentbox.store.state.ScreenState
import com.dropbox.desktop.componentbox.store.state.ThemeState
import com.dropbox.desktop.componentbox.util.id
import org.reduxkotlin.createThreadSafeStore

val store = createThreadSafeStore(
    reducer = ::rootReducer,
    preloadedState = AppState(
        componentState = ComponentState(),
        screenState = ScreenState(id()),
        themeState = ThemeState()
    )
)