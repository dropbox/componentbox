package com.dropbox.componentbox.store

import com.dropbox.componentbox.store.reducers.rootReducer
import com.dropbox.componentbox.store.state.AppState
import com.dropbox.componentbox.store.state.ComponentState
import com.dropbox.componentbox.store.state.ScreenState
import com.dropbox.componentbox.store.state.ThemeState
import com.dropbox.componentbox.utils.id
import org.reduxkotlin.createThreadSafeStore

val store = createThreadSafeStore(
    reducer = ::rootReducer,
    preloadedState = AppState(
        componentState = ComponentState(),
        screenState = ScreenState(id()),
        themeState = ThemeState()
    )
)