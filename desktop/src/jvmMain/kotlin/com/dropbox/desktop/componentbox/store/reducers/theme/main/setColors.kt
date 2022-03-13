package com.dropbox.desktop.componentbox.store.reducers.theme.main

import com.dropbox.desktop.componentbox.store.actions.ThemeAction
import com.dropbox.desktop.componentbox.store.state.ThemeState

internal fun ThemeState.setColors(action: ThemeAction.SetColors): ThemeState {
    return apply {
        colors = action.colors
    }
}
