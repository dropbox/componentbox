package com.dropbox.desktop.componentbox.store.reducers.screen.main

import com.dropbox.desktop.componentbox.store.state.ScreenState

internal fun ScreenState.togglePreview(): ScreenState {
    return apply {
        isPreview = !isPreview
    }
}
