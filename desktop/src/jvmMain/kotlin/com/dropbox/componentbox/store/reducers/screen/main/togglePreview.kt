package com.dropbox.componentbox.store.reducers.screen.main

import com.dropbox.componentbox.store.state.ScreenState

internal fun ScreenState.togglePreview(): ScreenState {
    return apply {
        isPreview = !isPreview
    }
}
