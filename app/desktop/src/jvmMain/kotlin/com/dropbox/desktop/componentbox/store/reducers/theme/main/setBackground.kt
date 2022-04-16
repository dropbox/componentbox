package com.dropbox.desktop.componentbox.store.reducers.theme.main

import com.dropbox.desktop.componentbox.store.actions.ThemeAction
import com.dropbox.desktop.componentbox.store.state.ThemeState

internal fun ThemeState.setBackground(action: ThemeAction.SetBackground): ThemeState {
    return apply {
        background = action.color
    }
}