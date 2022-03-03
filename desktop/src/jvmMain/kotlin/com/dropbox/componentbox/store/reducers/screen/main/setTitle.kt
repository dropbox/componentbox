package com.dropbox.componentbox.store.reducers.screen.main

import com.dropbox.componentbox.store.actions.ScreenAction
import com.dropbox.componentbox.store.state.ScreenState

internal fun ScreenState.setTitle(action: ScreenAction.SetTitle): ScreenState {
    return apply {
        title = action.title
    }
}
