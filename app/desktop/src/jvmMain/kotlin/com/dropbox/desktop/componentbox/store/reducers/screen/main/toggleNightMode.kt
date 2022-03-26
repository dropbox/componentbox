package com.dropbox.desktop.componentbox.store.reducers.screen.main

import com.dropbox.desktop.componentbox.store.state.ScreenState

internal fun ScreenState.toggleNightMode(): ScreenState {
    return apply {
        isNightMode = !isNightMode
    }
}
