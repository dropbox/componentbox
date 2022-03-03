package com.dropbox.componentbox.store.reducers.screen.main

import com.dropbox.componentbox.store.state.ScreenState

internal fun ScreenState.toggleBottomTabs(): ScreenState {
    return apply {
        showBottomTabs = !showBottomTabs
    }
}
