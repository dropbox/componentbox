package com.dropbox.desktop.componentbox.store.reducers.screen

import com.dropbox.desktop.componentbox.store.actions.ScreenAction
import com.dropbox.desktop.componentbox.store.reducers.screen.main.setHorizontalAlignment
import com.dropbox.desktop.componentbox.store.reducers.screen.main.setTitle
import com.dropbox.desktop.componentbox.store.reducers.screen.main.setVerticalArrangement
import com.dropbox.desktop.componentbox.store.reducers.screen.main.toggleBottomTabs
import com.dropbox.desktop.componentbox.store.reducers.screen.main.toggleNightMode
import com.dropbox.desktop.componentbox.store.reducers.screen.main.togglePreview
import com.dropbox.desktop.componentbox.store.state.ScreenState

fun screenReducer(state: ScreenState, action: Any): ScreenState {
    return state.copy().let { nextState ->
        when (action) {
            ScreenAction.ToggleBottomTabs -> nextState.toggleBottomTabs()
            ScreenAction.ToggleNightMode -> nextState.toggleNightMode()
            ScreenAction.TogglePreview -> nextState.togglePreview()

            is ScreenAction.SetHorizontalAlignment -> nextState.setHorizontalAlignment(action)
            is ScreenAction.SetTitle -> nextState.setTitle(action)
            is ScreenAction.SetVerticalArrangement -> nextState.setVerticalArrangement(action)

            else -> nextState
        }
    }
}