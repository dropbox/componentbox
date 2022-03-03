package com.dropbox.componentbox.store.reducers.theme.main

import com.dropbox.componentbox.store.actions.ThemeAction
import com.dropbox.componentbox.store.state.ThemeState

internal fun ThemeState.setBackground(action: ThemeAction.SetBackground): ThemeState {
    return apply {
        background = action.color
    }
}