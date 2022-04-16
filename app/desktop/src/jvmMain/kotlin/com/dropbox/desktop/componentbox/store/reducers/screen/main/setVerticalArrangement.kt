package com.dropbox.desktop.componentbox.store.reducers.screen.main

import com.dropbox.desktop.componentbox.store.actions.ScreenAction
import com.dropbox.desktop.componentbox.store.state.ScreenState

internal fun ScreenState.setVerticalArrangement(action: ScreenAction.SetVerticalArrangement): ScreenState {
    return apply {
        verticalArrangement = action.arrangement
    }
}
