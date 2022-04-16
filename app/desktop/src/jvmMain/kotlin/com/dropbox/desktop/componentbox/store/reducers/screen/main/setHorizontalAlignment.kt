package com.dropbox.desktop.componentbox.store.reducers.screen.main

import com.dropbox.desktop.componentbox.store.actions.ScreenAction
import com.dropbox.desktop.componentbox.store.state.ScreenState

internal fun ScreenState.setHorizontalAlignment(action: ScreenAction.SetHorizontalAlignment): ScreenState {
    return apply {
        horizontalAlignment = action.alignment
    }
}
