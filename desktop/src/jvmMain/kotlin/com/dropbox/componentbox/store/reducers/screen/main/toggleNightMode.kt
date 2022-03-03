package com.dropbox.componentbox.store.reducers.screen.main

import com.dropbox.componentbox.store.state.ScreenState

internal fun ScreenState.toggleNightMode(): ScreenState {
    return apply {
        isNightMode = !isNightMode
    }
}
