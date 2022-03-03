package com.dropbox.componentbox.store.reducers.theme.main

import com.dropbox.componentbox.store.actions.ThemeAction
import com.dropbox.componentbox.store.state.ThemeState

internal fun ThemeState.setColors(action: ThemeAction.SetColors): ThemeState {
    return apply {
        colors = action.colors
    }
}
