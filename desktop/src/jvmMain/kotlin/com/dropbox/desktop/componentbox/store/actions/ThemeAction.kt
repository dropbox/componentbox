package com.dropbox.desktop.componentbox.store.actions

import com.dropbox.componentbox.foundation.Color

sealed class ThemeAction {
    object ToggleNightMode : ThemeAction()
    data class SetColors(
        val colors: MutableList<Color>
    ) : ThemeAction()

    data class SetBackground(
        val color: Color
    ): ThemeAction()
}