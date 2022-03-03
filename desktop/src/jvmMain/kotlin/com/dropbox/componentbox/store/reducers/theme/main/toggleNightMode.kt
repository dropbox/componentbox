package com.dropbox.componentbox.store.reducers.theme.main

import com.dropbox.componentbox.store.state.ThemeState

internal fun ThemeState.toggleNightMode(): ThemeState {
    return apply {
        isNightMode = !isNightMode
    }
}
