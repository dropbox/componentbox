package com.dropbox.desktop.componentbox.store.reducers.screen.main

import com.dropbox.desktop.componentbox.store.actions.ScreenAction
import com.dropbox.desktop.componentbox.store.state.ScreenState

internal fun ScreenState.setTitle(action: ScreenAction.SetTitle): ScreenState {
    return apply {
        title = action.title
    }
}
