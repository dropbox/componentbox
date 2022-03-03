package com.dropbox.componentbox.store.reducers.screen.main

import com.dropbox.componentbox.store.actions.ScreenAction
import com.dropbox.componentbox.store.state.ScreenState

internal fun ScreenState.setHorizontalAlignment(action: ScreenAction.SetHorizontalAlignment): ScreenState {
    return apply {
        horizontalAlignment = action.alignment
    }
}
