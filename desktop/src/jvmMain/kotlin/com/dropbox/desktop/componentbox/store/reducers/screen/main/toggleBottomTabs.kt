package com.dropbox.desktop.componentbox.store.reducers.screen.main

import com.dropbox.desktop.componentbox.store.state.ScreenState

internal fun ScreenState.toggleBottomTabs(): ScreenState {
    return apply {
        showBottomTabs = !showBottomTabs
    }
}
