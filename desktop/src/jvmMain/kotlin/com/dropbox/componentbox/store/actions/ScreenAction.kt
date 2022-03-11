package com.dropbox.componentbox.store.actions

import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement

sealed class ScreenAction {
    data class SetTitle(val title: String) : ScreenAction()
    data class SetHorizontalAlignment(val alignment: Alignment) : ScreenAction()
    data class SetVerticalArrangement(val arrangement: Arrangement) : ScreenAction()
    object ToggleBottomTabs : ScreenAction()
    object ToggleNightMode : ScreenAction()
    object TogglePreview : ScreenAction()
}