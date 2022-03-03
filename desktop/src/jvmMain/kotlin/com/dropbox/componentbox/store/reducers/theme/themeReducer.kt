package com.dropbox.componentbox.store.reducers.theme

import com.dropbox.componentbox.store.actions.ThemeAction
import com.dropbox.componentbox.store.reducers.theme.main.setColors
import com.dropbox.componentbox.store.reducers.theme.main.toggleNightMode
import com.dropbox.componentbox.store.state.ThemeState

fun themeReducer(state: ThemeState, action: Any): ThemeState {
    return state.copy().let { nextState ->
        when (action) {
            ThemeAction.ToggleNightMode -> nextState.toggleNightMode()
            is ThemeAction.SetColors -> nextState.setColors(action)
            else -> nextState
        }
    }
}