package com.dropbox.desktop.componentbox.store.reducers.theme.main

import com.dropbox.desktop.componentbox.store.state.ThemeState

internal fun ThemeState.toggleNightMode(): ThemeState {
    return apply {
        isNightMode = !isNightMode
    }
}
