package com.dropbox.componentbox.store.reducers.screen.main

import com.dropbox.componentbox.store.actions.ScreenAction
import com.dropbox.componentbox.store.state.ScreenState

internal fun ScreenState.setVerticalArrangement(action: ScreenAction.SetVerticalArrangement): ScreenState {
    return apply {
        verticalArrangement = action.arrangement
    }
}
